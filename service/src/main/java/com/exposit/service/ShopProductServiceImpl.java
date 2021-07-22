package com.exposit.service;

import com.exposit.api.dao.CategoryDao;
import com.exposit.api.dao.ShopProductDao;
import com.exposit.api.service.ShopProductService;

import com.exposit.dao.util.CategoryDaoFactory;
import com.exposit.dao.util.DaoPropertiesHandler;
import com.exposit.dao.util.ShopProductDaoFactory;
import com.exposit.exceptions.DaoException;
import com.exposit.exceptions.ServiceException;
import com.exposit.marshelling.json.MarshallingShopProductJson;
import com.exposit.model.CategoryEntity;
import com.exposit.model.ProductEntity;
import com.exposit.model.ShopProductEntity;
import com.exposit.model.StoreEntity;
import com.exposit.model.utils.PriceQuantityInStore;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j
public class ShopProductServiceImpl implements ShopProductService {

    private static final String PROPERTY;
    private static final String NAME = "name";
    private static final String PRODUCER = "producer";
    private static final String PRICE = "price";
    private static final String QUANTITY = "quantity";
    private static final String STORE = "store";
    private static final String DESCRIPTION = "description";

    static {
        PROPERTY = DaoPropertiesHandler.getProperty("dao.serialization.config_dao_impl")
                .orElseThrow(() -> new ServiceException("Serialization path not found"));
    }

    private final ShopProductDao shopProductDao;
    private final CategoryDao categoryDao;
    private static ShopProductServiceImpl instance;
    private static final String FALSE_CATEGORY_NAME
            = "False category name";
    private static final String FALSE_ATTRIBUTE_NAME
            = "False attribute name";
    private static final String CAN_NOT_DELETE_SHOP_PRODUCT
            = "can not delete shopProduct";
    private static final String CAN_NOT_UPDATE_SHOP_PRODUCT
            = "can not update shopProduct";

    private ShopProductServiceImpl() {
        this.shopProductDao = ShopProductDaoFactory.getShopProductDaoFromProperties(PROPERTY);
        this.categoryDao = CategoryDaoFactory.getCategoryDaoFromProperties(PROPERTY);
    }

    public static ShopProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ShopProductServiceImpl();
        }
        return instance;
    }

    @Override
    public ShopProductEntity addShopProduct(ProductEntity product, java.lang.Integer price,
                                            java.lang.Integer quantity, StoreEntity store,
                                            String description) {
        ShopProductEntity shopProduct = new ShopProductEntity(product, price,
                quantity, store, description);
        shopProductDao.save(shopProduct);
        return shopProduct;
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
    public void updateShopProduct(Long id, ProductEntity product, java.lang.Integer price,
                                  java.lang.Integer quantity, StoreEntity store, String description) {
        if (shopProductDao.getById(id) != null) {
            ShopProductEntity shopProduct = new ShopProductEntity(product, price,
                    quantity, store, description);
            shopProduct.setId(id);
            shopProductDao.update(id, shopProduct);
        } else {
            log.warn(CAN_NOT_UPDATE_SHOP_PRODUCT);
            throw new ServiceException(CAN_NOT_UPDATE_SHOP_PRODUCT);
        }
    }

    @Override
    public ShopProductEntity getShopProductById(Long id) {
        return shopProductDao.getById(id);
    }

    @Override
    public List<ShopProductEntity> getAllShopProduct() {
        return shopProductDao.getAll();
    }

    @Override
    public void saveShopProductToFile() {
        MarshallingShopProductJson
                .serializeShopProduct(shopProductDao.getAll());
    }

    @Override
    public List<ShopProductEntity> sortByPrice() {
        return shopProductDao.sortByPrice();
    }

    @Override
    public List<ShopProductEntity> getGoodsFromCategory(String category) {
        List<CategoryEntity> categories = categoryDao.getAll();
        CategoryEntity categoryEntity = categories.stream()
                .filter(p -> p.getName().equals(category)).findAny()
                .orElse(null);
        List<ShopProductEntity> shopProducts = shopProductDao.getAll();
        if (categoryEntity != null) {
            return shopProducts.stream()
                    .filter(p -> p.getProduct().getCategoryList().contains(categoryEntity))
                    .collect(Collectors.toList());
        }
        throw new ServiceException(FALSE_CATEGORY_NAME);
    }

    @Override
    public List<ShopProductEntity>
    findByOneAttribute(String value, String attribute) {
        List<ShopProductEntity> goods = shopProductDao.getAll();
        switch (attribute) {
            case (NAME):
                return goods.stream()
                        .filter(p -> p.getProduct().getName().equals(value))
                        .collect(Collectors.toList());
            case (PRODUCER):
                return goods.stream()
                        .filter(p -> p.getProduct().getProducer().equals(value))
                        .collect(Collectors.toList());
            case (PRICE):
                return goods.stream()
                        .filter(p -> p.getPrice()
                                .equals(java.lang.Integer.parseInt(value)))
                        .collect(Collectors.toList());
            case (QUANTITY):
                return goods.stream()
                        .filter(p -> p.getQuantity()
                                .equals(java.lang.Integer.parseInt(value)))
                        .collect(Collectors.toList());
            case (STORE):
                return goods.stream()
                        .filter(p -> p.getStore().getName().equals(value))
                        .collect(Collectors.toList());
            case (DESCRIPTION):
                return goods.stream()
                        .filter(p -> p.getDescription().equals(value))
                        .collect(Collectors.toList());
            default:
                log.warn(FALSE_ATTRIBUTE_NAME);
                throw new DaoException(FALSE_ATTRIBUTE_NAME);
        }
    }

    @Override
    public List<ShopProductEntity> findByTwoAttribute(
            String value1, String attribute1,
            String value2, String attribute2) {
        List<ShopProductEntity> goods = shopProductDao.getAll();
        switch (attribute2) {
            case (NAME):
                switch (attribute1) {
                    case (PRODUCER):
                        return goods.stream()
                                .filter(p -> p.getProduct().getProducer()
                                        .equals(value1))
                                .filter(p -> p.getProduct().getName()
                                        .equals(value2))
                                .collect(Collectors.toList());
                    case (PRICE):
                        return goods.stream()
                                .filter(p -> p.getPrice().equals(java.lang.Integer
                                        .parseInt(value1)))
                                .filter(p -> p.getProduct().getName()
                                        .equals(value2))
                                .collect(Collectors.toList());
                    case (QUANTITY):
                        return goods.stream()
                                .filter(p -> p.getQuantity().equals(java.lang.Integer
                                        .parseInt(value1)))
                                .filter(p -> p.getProduct().getName()
                                        .equals(value2))
                                .collect(Collectors.toList());
                    case (STORE):
                        return goods.stream()
                                .filter(p -> p.getStore().getName()
                                        .equals(value1))
                                .filter(p -> p.getProduct().getName()
                                        .equals(value2))
                                .collect(Collectors.toList());
                    case (DESCRIPTION):
                        return goods.stream()
                                .filter(p -> p.getDescription()
                                        .equals(value1))
                                .filter(p -> p.getProduct().getName()
                                        .equals(value2))
                                .collect(Collectors.toList());
                    default:
                        log.warn(FALSE_ATTRIBUTE_NAME);
                        throw new DaoException(FALSE_ATTRIBUTE_NAME);
                }
            case (PRODUCER):
                switch (attribute1) {
                    case (NAME):
                        return goods.stream()
                                .filter(p -> p.getProduct().getName()
                                        .equals(value1))
                                .filter(p -> p.getProduct().getProducer()
                                        .equals(value2))
                                .collect(Collectors.toList());
                    case (PRICE):
                        return goods.stream()
                                .filter(p -> p.getPrice().equals(java.lang.Integer
                                        .parseInt(value1)))
                                .filter(p -> p.getProduct().getProducer()
                                        .equals(value2))
                                .collect(Collectors.toList());
                    case (QUANTITY):
                        return goods.stream()
                                .filter(p -> p.getQuantity().equals(java.lang.Integer
                                        .parseInt(value1)))
                                .filter(p -> p.getProduct().getProducer()
                                        .equals(value2))
                                .collect(Collectors.toList());
                    case (STORE):
                        return goods.stream()
                                .filter(p -> p.getStore().getName()
                                        .equals(value1))
                                .filter(p -> p.getProduct().getProducer()
                                        .equals(value2))
                                .collect(Collectors.toList());
                    case (DESCRIPTION):
                        return goods.stream()
                                .filter(p -> p.getDescription()
                                        .equals(value1))
                                .filter(p -> p.getProduct().getProducer()
                                        .equals(value2))
                                .collect(Collectors.toList());
                    default:
                        log.warn(FALSE_ATTRIBUTE_NAME);
                        throw new DaoException(FALSE_ATTRIBUTE_NAME);
                }
            case (PRICE):
                switch (attribute1) {
                    case (PRODUCER):
                        return goods.stream()
                                .filter(p -> p.getProduct().getProducer()
                                        .equals(value1))
                                .filter(p -> p.getPrice().equals(java.lang.Integer
                                        .parseInt(value2)))
                                .collect(Collectors.toList());
                    case (NAME):
                        return goods.stream()
                                .filter(p -> p.getProduct().getName()
                                        .equals(value1))
                                .filter(p -> p.getPrice().equals(java.lang.Integer
                                        .parseInt(value2)))
                                .collect(Collectors.toList());
                    case (QUANTITY):
                        return goods.stream()
                                .filter(p -> p.getQuantity().equals(java.lang.Integer
                                        .parseInt(value1)))
                                .filter(p -> p.getPrice().equals(java.lang.Integer
                                        .parseInt(value2)))
                                .collect(Collectors.toList());
                    case (STORE):
                        return goods.stream()
                                .filter(p -> p.getStore().getName()
                                        .equals(value1))
                                .filter(p -> p.getPrice().equals(java.lang.Integer
                                        .parseInt(value2)))
                                .collect(Collectors.toList());
                    case (DESCRIPTION):
                        return goods.stream()
                                .filter(p -> p.getDescription()
                                        .equals(value1))
                                .filter(p -> p.getPrice().equals(java.lang.Integer
                                        .parseInt(value2)))
                                .collect(Collectors.toList());
                    default:
                        log.warn(FALSE_ATTRIBUTE_NAME);
                        throw new DaoException(FALSE_ATTRIBUTE_NAME);
                }
            case (QUANTITY):
                switch (attribute1) {
                    case (PRODUCER):
                        return goods.stream()
                                .filter(p -> p.getProduct().getProducer()
                                        .equals(value1))
                                .filter(p -> p.getQuantity().equals(java.lang.Integer
                                        .parseInt(value2)))
                                .collect(Collectors.toList());
                    case (PRICE):
                        return goods.stream()
                                .filter(p -> p.getPrice().equals(java.lang.Integer
                                        .parseInt(value1)))
                                .filter(p -> p.getQuantity().equals(java.lang.Integer
                                        .parseInt(value2)))
                                .collect(Collectors.toList());
                    case (NAME):
                        return goods.stream()
                                .filter(p -> p.getProduct().getName()
                                        .equals(value1))
                                .filter(p -> p.getQuantity().equals(java.lang.Integer
                                        .parseInt(value2)))
                                .collect(Collectors.toList());
                    case (STORE):
                        return goods.stream()
                                .filter(p -> p.getStore().getName()
                                        .equals(value1))
                                .filter(p -> p.getQuantity().equals(java.lang.Integer
                                        .parseInt(value2)))
                                .collect(Collectors.toList());
                    case (DESCRIPTION):
                        return goods.stream()
                                .filter(p -> p.getDescription()
                                        .equals(value1))
                                .filter(p -> p.getQuantity().equals(java.lang.Integer
                                        .parseInt(value2)))
                                .collect(Collectors.toList());
                    default:
                        log.warn(FALSE_ATTRIBUTE_NAME);
                        throw new DaoException(FALSE_ATTRIBUTE_NAME);
                }
            case (STORE):
                switch (attribute1) {
                    case (PRODUCER):
                        return goods.stream()
                                .filter(p -> p.getProduct().getProducer()
                                        .equals(value1))
                                .filter(p -> p.getStore().getName()
                                        .equals(value2))
                                .collect(Collectors.toList());
                    case (PRICE):
                        return goods.stream()
                                .filter(p -> p.getPrice().equals(java.lang.Integer
                                        .parseInt(value1)))
                                .filter(p -> p.getStore().getName()
                                        .equals(value2))
                                .collect(Collectors.toList());
                    case (QUANTITY):
                        return goods.stream()
                                .filter(p -> p.getQuantity().equals(java.lang.Integer
                                        .parseInt(value1)))
                                .filter(p -> p.getStore().getName()
                                        .equals(value2))
                                .collect(Collectors.toList());
                    case (NAME):
                        return goods.stream()
                                .filter(p -> p.getProduct().getName()
                                        .equals(value1))
                                .filter(p -> p.getStore().getName()
                                        .equals(value2))
                                .collect(Collectors.toList());
                    case (DESCRIPTION):
                        return goods.stream()
                                .filter(p -> p.getDescription()
                                        .equals(value1))
                                .filter(p -> p.getStore().getName()
                                        .equals(value2))
                                .collect(Collectors.toList());
                    default:
                        log.warn(FALSE_ATTRIBUTE_NAME);
                        throw new DaoException(FALSE_ATTRIBUTE_NAME);
                }
            case (DESCRIPTION):
                switch (attribute1) {
                    case (PRODUCER):
                        return goods.stream()
                                .filter(p -> p.getProduct().getProducer()
                                        .equals(value1))
                                .filter(p -> p.getDescription()
                                        .equals(value2))
                                .collect(Collectors.toList());
                    case (STORE):
                        return goods.stream()
                                .filter(p -> p.getStore().getName()
                                        .equals(value1))
                                .filter(p -> p.getDescription()
                                        .equals(value2))
                                .collect(Collectors.toList());
                    case (NAME):
                        return goods.stream()
                                .filter(p -> p.getProduct().getName()
                                        .equals(value1))
                                .filter(p -> p.getDescription()
                                        .equals(value2))
                                .collect(Collectors.toList());
                    case (PRICE):
                        return goods.stream()
                                .filter(p -> p.getPrice().equals(java.lang.Integer
                                        .parseInt(value1)))
                                .filter(p -> p.getDescription()
                                        .equals(value2))
                                .collect(Collectors.toList());
                    case (QUANTITY):
                        return goods.stream()
                                .filter(p -> p.getQuantity().equals(java.lang.Integer
                                        .parseInt(value1)))
                                .filter(p -> p.getDescription()
                                        .equals(value2))
                                .collect(Collectors.toList());
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
        List<ShopProductEntity> shopProductList = shopProductDao.getAll();
        List<ShopProductEntity> shopProductInParticularStore
                = shopProductList.stream()
                .filter(p -> p.getStore().getName()
                        .equals(storeName)).collect(Collectors.toList());
        List<PriceQuantityInStore> priceQuantityInStoreList = new ArrayList<>();
        for (ShopProductEntity g : shopProductInParticularStore) {
            PriceQuantityInStore priceQuantityInStore =
                    new PriceQuantityInStore(g.getStore()
                            .getName(), g.getQuantity(), g.getPrice());
            priceQuantityInStoreList.add(priceQuantityInStore);

        }
        return priceQuantityInStoreList;
    }
}
