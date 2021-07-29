package com.exposite.service;

import com.exposit.api.dao.CategoryDao;
import com.exposit.api.dao.ShopProductDao;
import com.exposit.api.service.ShopProductService;

import com.exposit.dao.util.CategoryDaoFactory;
import com.exposit.dao.util.ShopProductDaoFactory;
import com.exposit.dto.ShopProductDto;
import com.exposit.exceptions.DaoException;
import com.exposit.exceptions.ServiceException;
import com.exposit.marshelling.json.MarshallingShopProductJson;
import com.exposit.model.CategoryEntity;
import com.exposit.model.ShopProductEntity;
import com.exposit.model.utils.PriceQuantityInStore;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exposit.dao.util.DaoPropertiesHandler;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j
@Service
public class ShopProductServiceImpl implements ShopProductService {
    private final ModelMapper mapper;
    private final ShopProductDao shopProductDao;
    private final CategoryDao categoryDao;

    private static final String FALSE_CATEGORY_NAME
            = "False category name";
    private static final String FALSE_ATTRIBUTE_NAME
            = "False attribute name";
    private static final String CAN_NOT_DELETE_SHOP_PRODUCT
            = "can not delete shopProduct";
    private static final String CAN_NOT_UPDATE_SHOP_PRODUCT
            = "can not update shopProduct";
    private static final String CAN_NOT_ADD_SHOP_PRODUCT
            = "can not add shopProduct";
    private static final String NAME = "name";
    private static final String PRODUCER = "producer";
    private static final String PRICE = "price";
    private static final String QUANTITY = "quantity";
    private static final String STORE = "store";
    private static final String DESCRIPTION = "description";

    Type listType = new TypeToken<List<ShopProductDto>>() {
    }.getType();

    @Autowired
    public ShopProductServiceImpl(ModelMapper mapper, ShopProductDao shopProductDao, CategoryDao categoryDao) {
        this.mapper = mapper;

        this.shopProductDao = shopProductDao;
        this.categoryDao = categoryDao;

    }

    @Override
    public void addShopProduct(ShopProductDto shopProductDto) {
        if (shopProductDto.getId() == null) {
            ShopProductEntity shopProduct = mapper.map(shopProductDto, ShopProductEntity.class);
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
            ShopProductEntity shopProduct = mapper.map(shopProductDto, ShopProductEntity.class);
            shopProduct.setId(id);
            shopProductDao.update(id, shopProduct);
        } else {
            log.warn(CAN_NOT_UPDATE_SHOP_PRODUCT);
            throw new ServiceException(CAN_NOT_UPDATE_SHOP_PRODUCT);
        }
    }

    @Override
    public ShopProductDto getShopProductById(Long id) {
        ShopProductEntity shopProductEntity = shopProductDao.getById(id);
        return mapper.map(shopProductEntity, ShopProductDto.class);
    }

    @Override
    public List<ShopProductDto> getAllShopProduct() {
        List<ShopProductEntity> shopProductEntityList = shopProductDao.getAll();
        Type listType = new TypeToken<List<ShopProductDto>>() {
        }.getType();
        return mapper.map(shopProductEntityList, listType);
    }

    @Override
    public void saveShopProductToFile() {
        MarshallingShopProductJson
                .serializeShopProduct(shopProductDao.getAll());
    }

    @Override
    public List<ShopProductDto> sortByPrice() {
        List<ShopProductEntity> shopProductEntityList = shopProductDao.sortByPrice();
        return mapper.map(shopProductEntityList, listType);
    }

    @Override
    public List<ShopProductDto> getGoodsFromCategory(String category) {
        List<CategoryEntity> categories = categoryDao.getAll();
        CategoryEntity categoryEntity = categories.stream()
                .filter(p -> p.getName().equals(category)).findAny()
                .orElse(null);
        List<ShopProductEntity> shopProducts = shopProductDao.getAll();
        if (categoryEntity != null) {
            List<ShopProductEntity> shopProductEntityList = shopProducts.stream()
                    .filter(p -> p.getProduct().getCategoryList().contains(categoryEntity))
                    .collect(Collectors.toList());

            return mapper.map(shopProductEntityList, listType);
        }
        throw new ServiceException(FALSE_CATEGORY_NAME);
    }

    @Override
    public List<ShopProductDto>
    findByOneAttribute(String value, String attribute) {
        List<ShopProductEntity> goods = shopProductDao.getAll();
        List<ShopProductEntity> shopProductEntityList;
        switch (attribute) {
            case (NAME):
                shopProductEntityList = shopProductDao.getAll().stream()
                        .filter(p -> p.getProduct().getName().equals(value))
                        .collect(Collectors.toList());
                return mapper.map(shopProductEntityList, listType);
            case (PRODUCER):
                shopProductEntityList = goods.stream()
                        .filter(p -> p.getProduct().getProducer().equals(value))
                        .collect(Collectors.toList());
                return mapper.map(shopProductEntityList, listType);
            case (PRICE):
                shopProductEntityList = goods.stream()
                        .filter(p -> p.getPrice()
                                .equals(java.lang.Integer.parseInt(value)))
                        .collect(Collectors.toList());
                return mapper.map(shopProductEntityList, listType);
            case (QUANTITY):
                shopProductEntityList = goods.stream()
                        .filter(p -> p.getQuantity()
                                .equals(java.lang.Integer.parseInt(value)))
                        .collect(Collectors.toList());
                return mapper.map(shopProductEntityList, listType);
            case (STORE):
                shopProductEntityList = goods.stream()
                        .filter(p -> p.getStore().getName().equals(value))
                        .collect(Collectors.toList());
                return mapper.map(shopProductEntityList, listType);
            case (DESCRIPTION):
                shopProductEntityList = goods.stream()
                        .filter(p -> p.getDescription().equals(value))
                        .collect(Collectors.toList());
                return mapper.map(shopProductEntityList, listType);
            default:
                log.warn(FALSE_ATTRIBUTE_NAME);
                throw new DaoException(FALSE_ATTRIBUTE_NAME);
        }
    }

    @Override
    public List<ShopProductDto> findByTwoAttribute(
            String value1, String attribute1,
            String value2, String attribute2) {
        List<ShopProductEntity> goods = shopProductDao.getAll();
        List<ShopProductEntity> shopProductEntityList;
        switch (attribute2) {
            case (NAME):
                switch (attribute1) {
                    case (PRODUCER):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getProduct().getProducer()
                                        .equals(value1))
                                .filter(p -> p.getProduct().getName()
                                        .equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (PRICE):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getPrice().equals(java.lang.Integer
                                        .parseInt(value1)))
                                .filter(p -> p.getProduct().getName()
                                        .equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (QUANTITY):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getQuantity().equals(java.lang.Integer
                                        .parseInt(value1)))
                                .filter(p -> p.getProduct().getName()
                                        .equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (STORE):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getStore().getName()
                                        .equals(value1))
                                .filter(p -> p.getProduct().getName()
                                        .equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (DESCRIPTION):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getDescription()
                                        .equals(value1))
                                .filter(p -> p.getProduct().getName()
                                        .equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    default:
                        log.warn(FALSE_ATTRIBUTE_NAME);
                        throw new DaoException(FALSE_ATTRIBUTE_NAME);
                }
            case (PRODUCER):
                switch (attribute1) {
                    case (NAME):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getProduct().getName()
                                        .equals(value1))
                                .filter(p -> p.getProduct().getProducer()
                                        .equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (PRICE):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getPrice().equals(java.lang.Integer
                                        .parseInt(value1)))
                                .filter(p -> p.getProduct().getProducer()
                                        .equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (QUANTITY):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getQuantity().equals(java.lang.Integer
                                        .parseInt(value1)))
                                .filter(p -> p.getProduct().getProducer()
                                        .equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (STORE):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getStore().getName()
                                        .equals(value1))
                                .filter(p -> p.getProduct().getProducer()
                                        .equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (DESCRIPTION):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getDescription()
                                        .equals(value1))
                                .filter(p -> p.getProduct().getProducer()
                                        .equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    default:
                        log.warn(FALSE_ATTRIBUTE_NAME);
                        throw new DaoException(FALSE_ATTRIBUTE_NAME);
                }
            case (PRICE):
                switch (attribute1) {
                    case (PRODUCER):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getProduct().getProducer()
                                        .equals(value1))
                                .filter(p -> p.getPrice().equals(java.lang.Integer
                                        .parseInt(value2)))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (NAME):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getProduct().getName()
                                        .equals(value1))
                                .filter(p -> p.getPrice().equals(java.lang.Integer
                                        .parseInt(value2)))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (QUANTITY):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getQuantity().equals(java.lang.Integer
                                        .parseInt(value1)))
                                .filter(p -> p.getPrice().equals(java.lang.Integer
                                        .parseInt(value2)))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (STORE):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getStore().getName()
                                        .equals(value1))
                                .filter(p -> p.getPrice().equals(java.lang.Integer
                                        .parseInt(value2)))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (DESCRIPTION):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getDescription()
                                        .equals(value1))
                                .filter(p -> p.getPrice().equals(java.lang.Integer
                                        .parseInt(value2)))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    default:
                        log.warn(FALSE_ATTRIBUTE_NAME);
                        throw new DaoException(FALSE_ATTRIBUTE_NAME);
                }
            case (QUANTITY):
                switch (attribute1) {
                    case (PRODUCER):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getProduct().getProducer()
                                        .equals(value1))
                                .filter(p -> p.getQuantity().equals(java.lang.Integer
                                        .parseInt(value2)))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (PRICE):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getPrice().equals(java.lang.Integer
                                        .parseInt(value1)))
                                .filter(p -> p.getQuantity().equals(java.lang.Integer
                                        .parseInt(value2)))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (NAME):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getProduct().getName()
                                        .equals(value1))
                                .filter(p -> p.getQuantity().equals(java.lang.Integer
                                        .parseInt(value2)))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (STORE):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getStore().getName()
                                        .equals(value1))
                                .filter(p -> p.getQuantity().equals(java.lang.Integer
                                        .parseInt(value2)))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (DESCRIPTION):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getDescription()
                                        .equals(value1))
                                .filter(p -> p.getQuantity().equals(java.lang.Integer
                                        .parseInt(value2)))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    default:
                        log.warn(FALSE_ATTRIBUTE_NAME);
                        throw new DaoException(FALSE_ATTRIBUTE_NAME);
                }
            case (STORE):
                switch (attribute1) {
                    case (PRODUCER):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getProduct().getProducer()
                                        .equals(value1))
                                .filter(p -> p.getStore().getName()
                                        .equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (PRICE):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getPrice().equals(java.lang.Integer
                                        .parseInt(value1)))
                                .filter(p -> p.getStore().getName()
                                        .equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (QUANTITY):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getQuantity().equals(java.lang.Integer
                                        .parseInt(value1)))
                                .filter(p -> p.getStore().getName()
                                        .equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (NAME):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getProduct().getName()
                                        .equals(value1))
                                .filter(p -> p.getStore().getName()
                                        .equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (DESCRIPTION):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getDescription()
                                        .equals(value1))
                                .filter(p -> p.getStore().getName()
                                        .equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    default:
                        log.warn(FALSE_ATTRIBUTE_NAME);
                        throw new DaoException(FALSE_ATTRIBUTE_NAME);
                }
            case (DESCRIPTION):
                switch (attribute1) {
                    case (PRODUCER):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getProduct().getProducer()
                                        .equals(value1))
                                .filter(p -> p.getDescription()
                                        .equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (STORE):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getStore().getName()
                                        .equals(value1))
                                .filter(p -> p.getDescription()
                                        .equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (NAME):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getProduct().getName()
                                        .equals(value1))
                                .filter(p -> p.getDescription()
                                        .equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (PRICE):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getPrice().equals(java.lang.Integer
                                        .parseInt(value1)))
                                .filter(p -> p.getDescription()
                                        .equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
                    case (QUANTITY):
                        shopProductEntityList = goods.stream()
                                .filter(p -> p.getQuantity().equals(java.lang.Integer
                                        .parseInt(value1)))
                                .filter(p -> p.getDescription()
                                        .equals(value2))
                                .collect(Collectors.toList());
                        return mapper.map(shopProductEntityList, listType);
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
