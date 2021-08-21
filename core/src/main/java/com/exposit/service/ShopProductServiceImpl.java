package com.exposit.service;

import com.exposit.api.dao.CategoryDao;
import com.exposit.api.dao.ShopProductDao;
import com.exposit.api.service.ShopProductService;
import com.exposit.domain.dto.ShopProductDto;
import com.exposit.domain.model.PriceQuantityInStore;
import com.exposit.domain.model.db.CategoryDb;
import com.exposit.domain.model.db.ShopProductDb;
import com.exposit.utils.exceptions.DaoException;
import com.exposit.utils.exceptions.ServiceException;
import com.exposit.utils.marshelling.json.MarshallingShopProductJson;
import com.exposit.utils.parsecsv.ParseFromCsv;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j
@RequiredArgsConstructor
@Service
public class ShopProductServiceImpl implements ShopProductService {

    private final ModelMapper mapper;
    private final ShopProductDao shopProductDao;
    private final CategoryDao categoryDao;
    private static final String FALSE_CATEGORY_NAME = "False category name";
    private static final String FALSE_ATTRIBUTE_NAME = "False attribute name";
    private static final String CAN_NOT_DELETE_SHOP_PRODUCT = "can not delete shopProduct";
    private static final String CAN_NOT_UPDATE_SHOP_PRODUCT = "can not update shopProduct";
    private static final String CAN_NOT_ADD_SHOP_PRODUCT = "can not add shopProduct";
    private static final String CAN_NOT_FIND_PRODUCT = "values are equal";
    private static final String NAME = "name";
    private static final String PRODUCER = "producer";
    private static final String PRICE = "price";
    private static final String QUANTITY = "quantity";
    private static final String STORE = "store";
    private static final String DESCRIPTION = "description";

    @Override
    public void addShopProduct(ShopProductDto shopProductDto) {
        if (shopProductDto.getId() == null) {
            ShopProductDb shopProduct = mapper.map(shopProductDto, ShopProductDb.class);
            shopProductDao.save(shopProduct);
        } else {
            log.warn(CAN_NOT_ADD_SHOP_PRODUCT);
            throw new DaoException(CAN_NOT_ADD_SHOP_PRODUCT);
        }
    }

    @Override
    public void deleteShopProduct(Long id) {
        try {
            shopProductDao.delete(shopProductDao.getById(id));
        } catch (DaoException e) {
            log.warn(CAN_NOT_DELETE_SHOP_PRODUCT, e);
            throw new ServiceException(CAN_NOT_DELETE_SHOP_PRODUCT, e);
        }
    }

    @Override
    public void updateShopProduct(Long id, ShopProductDto shopProductDto) {
        if (shopProductDao.getById(id) != null) {
            ShopProductDb shopProduct = mapper.map(shopProductDto, ShopProductDb.class);
            shopProduct.setId(id);
            shopProductDao.update(id, shopProduct);
        } else {
            log.warn(CAN_NOT_UPDATE_SHOP_PRODUCT);
            throw new ServiceException(CAN_NOT_UPDATE_SHOP_PRODUCT);
        }
    }

    @Override
    public ShopProductDto getShopProductById(Long id) {
        ShopProductDb shopProductDbEntity = shopProductDao.getById(id);
        return mapper.map(shopProductDbEntity, ShopProductDto.class);
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
        MarshallingShopProductJson.serializeShopProduct(shopProductDao.getAll());
    }

    @Override
    public List<ShopProductDto> sortByPrice() {
        List<ShopProductDb> shopProductDbEntityList = shopProductDao.sortByPrice();
        Type listType = new TypeToken<List<ShopProductDto>>() {
        }.getType();
        return mapper.map(shopProductDbEntityList, listType);
    }

    @Override
    public List<ShopProductDto> getGoodsFromCategory(String category) {
        Type listType = new TypeToken<List<ShopProductDto>>() {
        }.getType();
        List<CategoryDb> categories = categoryDao.getAll();
        CategoryDb categoryDbEntity = categories.stream()
                .filter(p -> p.getName().equals(category))
                .findAny().orElse(null);
        List<ShopProductDb> shopProducts = shopProductDao.getAll();
        if (categoryDbEntity != null) {
            List<ShopProductDb> shopProductDbEntityList = shopProducts.stream()
                    .filter(p -> p.getProduct().getCategoryList().contains(categoryDbEntity))
                    .collect(Collectors.toList());
            return mapper.map(shopProductDbEntityList, listType);
        }
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
            List<ShopProductDb> goodDb = mapper.map(this.filterByAttribute(val1, attrib1, goods), listType);
            return this.filterByAttribute(val2, attrib2, goodDb);
        }
        log.warn(CAN_NOT_FIND_PRODUCT);
        throw new DaoException(CAN_NOT_FIND_PRODUCT);
    }

    @Override
    public List<PriceQuantityInStore> infoAboutPriceQuantityInStore(
            String storeName) {
        List<ShopProductDb> shopProductList = shopProductDao.getAll();
        List<ShopProductDb> shopProductInParticularStore = shopProductList.stream()
                .filter(p -> p.getStore().getName().equals(storeName))
                .collect(Collectors.toList());
        List<PriceQuantityInStore> priceQuantityInStoreList = new ArrayList<>();
        for (ShopProductDb g : shopProductInParticularStore) {
            PriceQuantityInStore priceQuantityInStore = new PriceQuantityInStore(
                    g.getPrice(), g.getQuantity(), g.getStore().getName());
            priceQuantityInStoreList.add(priceQuantityInStore);

        }
        return priceQuantityInStoreList;
    }

    private List<ShopProductDto> filterByAttribute(String value, String attribute, List<ShopProductDb> goods) {
        Type listType = new TypeToken<List<ShopProductDto>>() {
        }.getType();
        List<ShopProductDb> shopProductDbEntityList;
        switch (attribute) {
            case (NAME):
                shopProductDbEntityList = goods.stream()
                        .filter(p -> p.getProduct().getName().equals(value))
                        .collect(Collectors.toList());
                return mapper.map(shopProductDbEntityList, listType);
            case (PRODUCER):
                shopProductDbEntityList = goods.stream()
                        .filter(p -> p.getProduct().getProducer().equals(value))
                        .collect(Collectors.toList());
                return mapper.map(shopProductDbEntityList, listType);
            case (PRICE):
                shopProductDbEntityList = goods.stream()
                        .filter(p -> p.getPrice().equals(java.lang.Double.parseDouble(value)))
                        .collect(Collectors.toList());
                return mapper.map(shopProductDbEntityList, listType);
            case (QUANTITY):
                shopProductDbEntityList = goods.stream()
                        .filter(p -> p.getQuantity().equals(java.lang.Integer.parseInt(value)))
                        .collect(Collectors.toList());
                return mapper.map(shopProductDbEntityList, listType);
            case (STORE):
                shopProductDbEntityList = goods.stream()
                        .filter(p -> p.getStore().getName().equals(value))
                        .collect(Collectors.toList());
                return mapper.map(shopProductDbEntityList, listType);
            case (DESCRIPTION):
                shopProductDbEntityList = goods.stream()
                        .filter(p -> p.getDescription().equals(value))
                        .collect(Collectors.toList());
                return mapper.map(shopProductDbEntityList, listType);
            default:
                log.warn(FALSE_ATTRIBUTE_NAME);
                throw new DaoException(FALSE_ATTRIBUTE_NAME);
        }
    }

    @Async
    @Override
    public void updateShopProductsFromCsv() {
        List<ShopProductDb> listFromCsv = ParseFromCsv.parseFileFromCsv();
        System.out.println("" + Thread.currentThread().getName());
        for (int i = 0; i < listFromCsv.size(); i++) {
            Long id = listFromCsv.get(i).getId();
            ShopProductDb shopProductDb = shopProductDao.getById(id);
            shopProductDb.setPrice(listFromCsv.get(i).getPrice());
            shopProductDb.setDescription(listFromCsv.get(i).getDescription());
            shopProductDao.update((long) i + 1, shopProductDb);
        }
        ParseFromCsv.moveToSaveDirChangeName();

    }
}
