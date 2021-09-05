package com.exposit.service;

import com.exposit.api.dao.CategoryDao;
import com.exposit.api.dao.ShopProductDao;
import com.exposit.api.service.ShopProductService;
import com.exposit.dao.daorepository.LogInfoDaoRepositoryImpl;
import com.exposit.domain.dto.PriceQuantityInStoreDto;
import com.exposit.domain.dto.ShopProductDto;
import com.exposit.domain.model.PriceQuantityInStore;
import com.exposit.domain.model.db.CategoryDb;
import com.exposit.domain.model.db.LogInfoDb;
import com.exposit.domain.model.db.ShopProductDb;
import com.exposit.utils.exceptions.DaoException;
import com.exposit.utils.exceptions.NotFoundException;
import com.exposit.utils.exceptions.ServiceException;
import com.exposit.utils.parsecsv.ParseFromCsv;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * Implementation of {@link ShopProductService} interface.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@RequiredArgsConstructor
@Service
public class ShopProductServiceImpl implements ShopProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ShopProductServiceImpl.class);
    private final ModelMapper mapper;
    private final ShopProductDao shopProductDao;
    private final CategoryDao categoryDao;
    private final LogInfoDaoRepositoryImpl logInfoDao;
    private static final String FALSE_CATEGORY_NAME = "False category name";
    private static final String FALSE_ATTRIBUTE_NAME = "False attribute name";
    private static final String CAN_NOT_DELETE_SHOP_PRODUCT = "can not delete shopProduct";
    private static final String CAN_NOT_UPDATE_SHOP_PRODUCT = "can not update shopProduct";
    private static final String CAN_NOT_ADD_SHOP_PRODUCT = "can not add shopProduct";
    private static final String CAN_NOT_FIND_PRODUCT = "values are equal";
    private static final String ERROR_IN_STRING = "error reading a string";
    private static final String NAME = "name";
    private static final String PRODUCER = "producer";
    private static final String PRICE = "price";
    private static final String QUANTITY = "quantity";
    private static final String STORE = "store";
    private static final String DESCRIPTION = "description";

    @Override
    public void addShopProduct(ShopProductDto shopProductDto) {
        if (shopProductDto.getId() == null) {
            try {
                ShopProductDb shopProduct = mapper.map(shopProductDto, ShopProductDb.class);
                shopProductDao.save(shopProduct);
            } catch (Exception e) {
                LOG.error(CAN_NOT_ADD_SHOP_PRODUCT);
                throw new ServiceException(CAN_NOT_ADD_SHOP_PRODUCT, e);
            }
        }
    }

    @Override
    public void deleteShopProduct(Long id) {
        try {
            shopProductDao.delete(shopProductDao.getById(id));
        } catch (DaoException e) {
            LOG.error(CAN_NOT_DELETE_SHOP_PRODUCT);
            throw new ServiceException(CAN_NOT_DELETE_SHOP_PRODUCT, e);
        }
    }

    @Override
    public void updateShopProduct(Long id, ShopProductDto shopProductDto) {
        if (shopProductDao.getById(id) != null) {
            try {
                ShopProductDb shopProduct = mapper.map(shopProductDto, ShopProductDb.class);
                shopProduct.setId(id);
                shopProductDao.update(id, shopProduct);
            } catch (NotFoundException e) {
                LOG.error(CAN_NOT_UPDATE_SHOP_PRODUCT);
                throw new ServiceException(CAN_NOT_UPDATE_SHOP_PRODUCT, e);
            }
        }
    }

    @Override
    public ShopProductDto getShopProductById(Long id) {
        ShopProductDb shopProductDb = shopProductDao.getById(id);
        return mapper.map(shopProductDb, ShopProductDto.class);
    }

    @Override
    public List<ShopProductDto> getAllShopProduct() {
        List<ShopProductDb> shopProductDbList = shopProductDao.getAll();
        Type listType = new TypeToken<List<ShopProductDto>>() {
        }.getType();
        return mapper.map(shopProductDbList, listType);
    }

    @Override
    public void saveShopProductToFile() {
        shopProductDao.saveToFile(shopProductDao.getAll());
    }

    @Override
    public List<ShopProductDto> sortByPrice() {
        List<ShopProductDb> shopProductDbList = shopProductDao.sortByPrice();
        Type listType = new TypeToken<List<ShopProductDto>>() {
        }.getType();
        return mapper.map(shopProductDbList, listType);
    }

    @Override
    public List<ShopProductDto> getGoodsFromCategory(String category) {
        Type listType = new TypeToken<List<ShopProductDto>>() {
        }.getType();
        List<CategoryDb> categories = categoryDao.getAll();
        CategoryDb categoryDb = categories.stream()
                .filter(p -> p.getName().equals(category))
                .findAny().orElse(null);
        List<ShopProductDb> shopProducts = shopProductDao.getAll();
        if (categoryDb != null) {
            List<ShopProductDb> shopProductDbList = shopProducts.stream()
                    .filter(p -> p.getProduct().getCategoryList().contains(categoryDb))
                    .collect(Collectors.toList());

            return mapper.map(shopProductDbList, listType);
        }
        LOG.error(FALSE_CATEGORY_NAME);
        throw new ServiceException(FALSE_CATEGORY_NAME);
    }

    @Override
    public List<ShopProductDto> findByOneAttribute(String value, String attribute) {
        List<ShopProductDb> goods = shopProductDao.getAll();
        return this.filterByAttribute(value, attribute, goods);
    }


    @Override
    public List<ShopProductDto> findByTwoAttribute(String val1, String attrib1, String val2, String attrib2) {
        if (!val1.equals(val2)) {
            List<ShopProductDb> goods = shopProductDao.getAll();
            Type listType = new TypeToken<List<ShopProductDb>>() {
            }.getType();
            List<ShopProductDto> productDtoList = this.filterByAttribute(val1, attrib1, goods);
            List<ShopProductDb> productDbList = mapper.map(productDtoList, listType);
            return this.filterByAttribute(val2, attrib2, productDbList);
        }
        LOG.error(CAN_NOT_FIND_PRODUCT);
        throw new ServiceException(CAN_NOT_FIND_PRODUCT);
    }

    @Override
    public List<PriceQuantityInStoreDto> infoAboutPriceQuantityInStore(String storeName) {
        List<ShopProductDb> shopProductList = shopProductDao.getAll();
        List<ShopProductDb> shopProductInParticularStore = shopProductList.stream()
                .filter(p -> p.getStore().getName().equals(storeName))
                .collect(Collectors.toList());
        List<PriceQuantityInStore> priceQuantityInStoreList = new ArrayList<>();
        for (ShopProductDb g : shopProductInParticularStore) {
            PriceQuantityInStore priceQuantityInStore = new PriceQuantityInStore(
                    g.getProduct(), g.getPrice(), g.getQuantity(), g.getStore().getName());
            priceQuantityInStoreList.add(priceQuantityInStore);

        }
        Type listType = new TypeToken<List<PriceQuantityInStore>>() {
        }.getType();
        return mapper.map(priceQuantityInStoreList, listType);
    }

    private List<ShopProductDto> filterByAttribute(String value, String attribute, List<ShopProductDb> goods) {
        Type listType = new TypeToken<List<ShopProductDto>>() {
        }.getType();
        List<ShopProductDb> shopProductDbList;
        switch (attribute) {
            case (NAME) -> {
                shopProductDbList = goods.stream()
                        .filter(p -> p.getProduct().getName().equals(value))
                        .collect(Collectors.toList());
                return mapper.map(shopProductDbList, listType);
            }
            case (PRODUCER) -> {
                shopProductDbList = goods.stream()
                        .filter(p -> p.getProduct().getProducer().equals(value))
                        .collect(Collectors.toList());
                return mapper.map(shopProductDbList, listType);
            }
            case (PRICE) -> {
                shopProductDbList = goods.stream()
                        .filter(p -> p.getPrice().equals(Double.parseDouble(value)))
                        .collect(Collectors.toList());
                return mapper.map(shopProductDbList, listType);
            }
            case (QUANTITY) -> {
                shopProductDbList = goods.stream()
                        .filter(p -> p.getQuantity().equals(Integer.parseInt(value)))
                        .collect(Collectors.toList());
                return mapper.map(shopProductDbList, listType);
            }
            case (STORE) -> {
                shopProductDbList = goods.stream()
                        .filter(p -> p.getStore().getName().equals(value))
                        .collect(Collectors.toList());
                return mapper.map(shopProductDbList, listType);
            }
            case (DESCRIPTION) -> {
                shopProductDbList = goods.stream()
                        .filter(p -> p.getDescription().equals(value))
                        .collect(Collectors.toList());
                return mapper.map(shopProductDbList, listType);
            }
            default -> {
                LOG.error(FALSE_ATTRIBUTE_NAME);
                throw new ServiceException(FALSE_ATTRIBUTE_NAME);
            }
        }
    }

    @Async
    @Override
    public void updateShopProductsFromCsv() {
        long startTime = System.currentTimeMillis();
        LOG.info("" + Thread.currentThread().getName());
        Map<List<ShopProductDto>, String> map = ParseFromCsv.parseEntityFromCsv();
        if (map.size() > 0) {
            Map.Entry<List<ShopProductDto>, String> entry = map.entrySet().iterator().next();
            List<ShopProductDto> listFromCsv = entry.getKey();
            Type listType = new TypeToken<List<ShopProductDb>>() {
            }.getType();
            List<ShopProductDb> productDbList = mapper.map(listFromCsv, listType);
            long j = 0;
            for (int i = 0; i < productDbList.size(); i++) {
                try {
                    if (productDbList.get(i).getId() != null && productDbList.get(i).getId() > 0
                            && productDbList.get(i).getPrice() != null && productDbList.get(i).getPrice() > 0
                            && productDbList.get(i).getDescription() != null
                            && productDbList.get(i).getDescription().length() > 0) {
                        Long id = productDbList.get(i).getId();
                        ShopProductDb shopProductDb = shopProductDao.getById(id);
                        shopProductDb.setPrice(productDbList.get(i).getPrice());
                        shopProductDb.setDescription(productDbList.get(i).getDescription());
                        shopProductDao.update((long) i + 1, shopProductDb);
                        j++;
                    }
                } catch (NotFoundException e) {
                    LOG.error(ERROR_IN_STRING);
                    throw new ServiceException(ERROR_IN_STRING, e);
                }
            }
            long endTime = System.currentTimeMillis();
            String path = entry.getValue();
            LogInfoDb logInfoDb = new LogInfoDb();
            logInfoDb.setNumberErrors((long) productDbList.size() - j);
            logInfoDb.setNumberUpdates(j);
            logInfoDb.setPath(path);
            logInfoDb.setWorkTime(endTime - startTime);
            logInfoDao.save(logInfoDb);
            LOG.info("data successfully updated");
        }
        LOG.info("" + Thread.currentThread().getName() + " finish work");
    }


}
