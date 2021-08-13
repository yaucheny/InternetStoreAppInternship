package com.exposite.service;

import com.exposit.api.dao.CategoryDao;
import com.exposit.api.dao.ShopProductDao;
import com.exposit.api.service.ShopProductService;
import com.exposit.dto.ShopProductDto;
import com.exposit.exceptions.DaoException;
import com.exposit.exceptions.ServiceException;
import com.exposit.marshelling.json.MarshallingShopProductJson;
import com.exposit.model.PriceQuantityInStore;
import com.exposit.model.db.CategoryDb;
import com.exposit.model.db.ShopProductDb;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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
    private static final String NAME = "name";
    private static final String PRODUCER = "producer";
    private static final String PRICE = "price";
    private static final String QUANTITY = "quantity";
    private static final String STORE = "store";
    private static final String DESCRIPTION = "description";

    Type listType = new TypeToken<List<ShopProductDto>>() {
    }.getType();

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
        List<ShopProductDb> shopProductDbEntityList = shopProductDao.getAll();
        return mapper.map(shopProductDbEntityList, listType);
    }

    @Override
    public void saveShopProductToFile() {
        MarshallingShopProductJson.serializeShopProduct(shopProductDao.getAll());
    }

    @Override
    public List<ShopProductDto> sortByPrice() {
        List<ShopProductDb> shopProductDbEntityList = shopProductDao.sortByPrice();
        return mapper.map(shopProductDbEntityList, listType);
    }

    @Override
    public List<ShopProductDto> getGoodsFromCategory(String category) {
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
    public List<ShopProductDto>
    findByOneAttribute(String value, String attribute) {
        List<ShopProductDb> goods = shopProductDao.getAll();
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

    @Override
    public List<ShopProductDto> findByTwoAttribute(
            String value1, String attribute1,
            String value2, String attribute2) {
        List<ShopProductDb> goods = shopProductDao.getAll();
        List<ShopProductDb> shopProductDbEntityList;
        switch (attribute2) {
            case (NAME):
                switch (attribute1) {
                    case (PRODUCER):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getProduct().getProducer().equals(value1))
                                .filter(p -> p.getProduct().getName().equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (PRICE):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getPrice().equals(java.lang.Double.parseDouble(value1)))
                                .filter(p -> p.getProduct().getName().equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (QUANTITY):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getQuantity().equals(java.lang.Integer.parseInt(value1)))
                                .filter(p -> p.getProduct().getName().equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (STORE):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getStore().getName().equals(value1))
                                .filter(p -> p.getProduct().getName().equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (DESCRIPTION):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getDescription().equals(value1))
                                .filter(p -> p.getProduct().getName().equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    default:
                        log.warn(FALSE_ATTRIBUTE_NAME);
                        throw new DaoException(FALSE_ATTRIBUTE_NAME);
                }
            case (PRODUCER):
                switch (attribute1) {
                    case (NAME):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getProduct().getName().equals(value1))
                                .filter(p -> p.getProduct().getProducer().equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (PRICE):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getPrice().equals(java.lang.Double.parseDouble(value1)))
                                .filter(p -> p.getProduct().getProducer().equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (QUANTITY):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getQuantity().equals(java.lang.Integer.parseInt(value1)))
                                .filter(p -> p.getProduct().getProducer().equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (STORE):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getStore().getName().equals(value1))
                                .filter(p -> p.getProduct().getProducer().equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (DESCRIPTION):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getDescription().equals(value1))
                                .filter(p -> p.getProduct().getProducer().equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    default:
                        log.warn(FALSE_ATTRIBUTE_NAME);
                        throw new DaoException(FALSE_ATTRIBUTE_NAME);
                }
            case (PRICE):
                switch (attribute1) {
                    case (PRODUCER):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getProduct().getProducer().equals(value1))
                                .filter(p -> p.getPrice().equals(java.lang.Double.parseDouble(value2)))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (NAME):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getProduct().getName().equals(value1))
                                .filter(p -> p.getPrice().equals(java.lang.Double.parseDouble(value2)))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (QUANTITY):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getQuantity().equals(java.lang.Integer.parseInt(value1)))
                                .filter(p -> p.getPrice().equals(java.lang.Double.parseDouble(value2)))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (STORE):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getStore().getName().equals(value1))
                                .filter(p -> p.getPrice().equals(java.lang.Double.parseDouble(value2)))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (DESCRIPTION):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getDescription().equals(value1))
                                .filter(p -> p.getPrice().equals(java.lang.Double.parseDouble(value2)))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    default:
                        log.warn(FALSE_ATTRIBUTE_NAME);
                        throw new DaoException(FALSE_ATTRIBUTE_NAME);
                }
            case (QUANTITY):
                switch (attribute1) {
                    case (PRODUCER):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getProduct().getProducer().equals(value1))
                                .filter(p -> p.getQuantity().equals(java.lang.Integer.parseInt(value2)))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (PRICE):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getPrice().equals(java.lang.Double.parseDouble(value1)))
                                .filter(p -> p.getQuantity().equals(java.lang.Integer.parseInt(value2)))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (NAME):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getProduct().getName().equals(value1))
                                .filter(p -> p.getQuantity().equals(java.lang.Integer.parseInt(value2)))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (STORE):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getStore().getName().equals(value1))
                                .filter(p -> p.getQuantity().equals(java.lang.Integer.parseInt(value2)))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (DESCRIPTION):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getDescription().equals(value1))
                                .filter(p -> p.getQuantity().equals(java.lang.Integer.parseInt(value2)))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    default:
                        log.warn(FALSE_ATTRIBUTE_NAME);
                        throw new DaoException(FALSE_ATTRIBUTE_NAME);
                }
            case (STORE):
                switch (attribute1) {
                    case (PRODUCER):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getProduct().getProducer().equals(value1))
                                .filter(p -> p.getStore().getName().equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (PRICE):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getPrice().equals(java.lang.Double.parseDouble(value1)))
                                .filter(p -> p.getStore().getName().equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (QUANTITY):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getQuantity().equals(java.lang.Integer.parseInt(value1)))
                                .filter(p -> p.getStore().getName().equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (NAME):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getProduct().getName().equals(value1))
                                .filter(p -> p.getStore().getName().equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (DESCRIPTION):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getDescription().equals(value1))
                                .filter(p -> p.getStore().getName().equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    default:
                        log.warn(FALSE_ATTRIBUTE_NAME);
                        throw new DaoException(FALSE_ATTRIBUTE_NAME);
                }
            case (DESCRIPTION):
                switch (attribute1) {
                    case (PRODUCER):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getProduct().getProducer().equals(value1))
                                .filter(p -> p.getDescription().equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (STORE):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getStore().getName().equals(value1))
                                .filter(p -> p.getDescription().equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (NAME):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getProduct().getName().equals(value1))
                                .filter(p -> p.getDescription().equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (PRICE):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getPrice().equals(java.lang.Double.parseDouble(value1)))
                                .filter(p -> p.getDescription().equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    case (QUANTITY):
                        shopProductDbEntityList = goods.stream()
                                .filter(p -> p.getQuantity().equals(java.lang.Integer.parseInt(value1)))
                                .filter(p -> p.getDescription().equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductDbEntityList, listType);
                    default:
                        log.warn(FALSE_ATTRIBUTE_NAME);
                        throw new DaoException(FALSE_ATTRIBUTE_NAME);
                }

            default:
                log.warn(FALSE_ATTRIBUTE_NAME);
                throw new DaoException(FALSE_ATTRIBUTE_NAME);
        }
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
}
