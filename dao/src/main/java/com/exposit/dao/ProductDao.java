package com.exposit.dao;

import com.exposit.api.dao.IProductDao;
import com.exposit.exceptions.DaoException;
import com.exposit.idGenerators.IdGenerator;
import com.exposit.marshelling.UnMarshallingJsonHandlerProduct;
import com.exposit.model.*;
import com.exposit.model.utils.PriceQuantityInStore;
import lombok.extern.log4j.Log4j;

import java.util.*;
import java.util.stream.Collectors;

@Log4j
public class ProductDao extends AbstractDao<Product> implements IProductDao {

    private static ProductDao instance;
    private final static String FALSE_CATEGORY_NAME = "False category name";

    private ProductDao() {
        List<Product> product = UnMarshallingJsonHandlerProduct.deSerializeProduct();
        for (Product entity : product) {
            entity.setId(IdGenerator.generateProductId());
            this.save(entity);
        }
    }

    public static ProductDao getInstance() {
        if (instance == null) {
            instance = new ProductDao();
        }
        return instance;
    }

    @Override
    public void save(Product entity) {
        entity.setId(IdGenerator.generateProductId());
        repository.add(entity);
    }

    @Override
    public List<Product> sortByPrice() {
        List<Product> goods = instance.getAll();

    return goods.stream().sorted(Comparator.comparingInt(Product::getProductPrice)).collect(Collectors.toList());
    }

    @Override
    public List<PriceQuantityInStore> infoAboutPriceQuantityInStore(String storeName) {
        List<Product> productList = instance.getAll();
        List<Product> productInParticularStore = productList.stream().filter(p -> p.getStore().getStoreName().equals(storeName)).collect(Collectors.toList());
        List<PriceQuantityInStore> priceQuantityInStoreList=new ArrayList<>();
        for (Product g : productInParticularStore) {
            PriceQuantityInStore priceQuantityInStore = new PriceQuantityInStore(g.getStore().getStoreName(),g.getProductQuantity(),g.getProductPrice());
            priceQuantityInStoreList.add(priceQuantityInStore);

        }
        return priceQuantityInStoreList;
    }
    @Override
    public List<Product> getGoodsFromCategory(String category) {
        List<Product> goods = instance.getAll();
        switch (category) {
            case ("ADULTS"):
                return goods.stream().filter(p -> p.getCategoryOne().equals(CategoryOne.ADULTS)).collect(Collectors.toList());
            case ("CHILDREN"):
                return goods.stream().filter(p -> p.getCategoryOne().equals(CategoryOne.CHILDREN)).collect(Collectors.toList());
            case ("ANIMALS"):
                return goods.stream().filter(p -> p.getCategoryOne().equals(CategoryOne.ANIMALS)).collect(Collectors.toList());
            case ("FOOD"):
                return goods.stream().filter(p -> p.getCategoryTwo().equals(CategoryTwo.FOOD)).collect(Collectors.toList());
            case ("NON_FOOD"):
                return goods.stream().filter(p -> p.getCategoryTwo().equals(CategoryTwo.NON_FOOD)).collect(Collectors.toList());
            case ("TECHNICS"):
                return goods.stream().filter(p -> p.getCategoryThree().equals(CategoryThree.TECHNICS)).collect(Collectors.toList());
            case ("CLOTHES"):
                return goods.stream().filter(p -> p.getCategoryThree().equals(CategoryThree.CLOTHES)).collect(Collectors.toList());
            case ("NUTRITION"):
                return goods.stream().filter(p -> p.getCategoryThree().equals(CategoryThree.NUTRITION)).collect(Collectors.toList());
            default:
                log.warn(FALSE_CATEGORY_NAME);
                throw new DaoException(FALSE_CATEGORY_NAME);
        }
    }

    @Override
    public List<Product> findByOneAttribute(String value, String attribute) {
        List<Product> goods = instance.getAll();
        switch (attribute) {
            case ("productName"):
                return goods.stream().filter(p -> p.getProductName().equals(value))
                        .collect(Collectors.toList());
            case ("productProducer"):
                return goods.stream().filter(p -> p.getProductProducer().equals(value))
                        .collect(Collectors.toList());
            case ("productPrice"):
                return goods.stream().filter(p -> p.getProductPrice().equals(Integer.parseInt(value)))
                        .collect(Collectors.toList());
            case ("productQuantity"):
                return goods.stream().filter(p -> p.getProductQuantity().equals(Integer.parseInt(value)))
                        .collect(Collectors.toList());
            case ("storeName"):
                return goods.stream().filter(p -> p.getStore().getStoreName().equals(value))
                        .collect(Collectors.toList());
            default:
                log.warn(FALSE_CATEGORY_NAME);
                throw new DaoException(FALSE_CATEGORY_NAME);
        }
    }

    @Override
    public List<Product> findByTwoAttribute(String value1, String attribute1,
                                            String value2, String attribute2) {
        List<Product> goods = instance.getAll();
        switch (attribute2) {
            case ("productName"):
                switch (attribute1) {
                    case ("productProducer"):
                        return goods.stream().filter(p -> p.getProductProducer().equals(value1))
                                .filter(p -> p.getProductName().equals(value2))
                                .collect(Collectors.toList());
                    case ("productPrice"):
                        return goods.stream().filter(p -> p.getProductPrice().equals(Integer.parseInt(value1)))
                                .filter(p -> p.getProductName().equals(value2))
                                .collect(Collectors.toList());
                    case ("productQuantity"):
                        return goods.stream().filter(p -> p.getProductQuantity().equals(Integer.parseInt(value1)))
                                .filter(p -> p.getProductName().equals(value2))
                                .collect(Collectors.toList());
                    case ("storeName"):
                        return goods.stream().filter(p -> p.getStore().getStoreName().equals(value1))
                                .filter(p -> p.getProductName().equals(value2))
                                .collect(Collectors.toList());
                }
            case ("productProducer"):
                switch (attribute1) {
                    case ("productName"):
                        return goods.stream().filter(p -> p.getProductName().equals(value1))
                                .filter(p -> p.getProductProducer().equals(value2))
                                .collect(Collectors.toList());
                    case ("productPrice"):
                        return goods.stream().filter(p -> p.getProductPrice().equals(Integer.parseInt(value1)))
                                .filter(p -> p.getProductProducer().equals(value2))
                                .collect(Collectors.toList());
                    case ("productQuantity"):
                        return goods.stream().filter(p -> p.getProductQuantity().equals(Integer.parseInt(value1)))
                                .filter(p -> p.getProductProducer().equals(value2))
                                .collect(Collectors.toList());
                    case ("storeName"):
                        return goods.stream().filter(p -> p.getStore().getStoreName().equals(value1))
                                .filter(p -> p.getProductProducer().equals(value2))
                                .collect(Collectors.toList());
                }
            case ("productPrice"):
                switch (attribute1) {
                    case ("productProducer"):
                        return goods.stream().filter(p -> p.getProductProducer().equals(value1))
                                .filter(p -> p.getProductPrice().equals(Integer.parseInt(value2)))
                                .collect(Collectors.toList());
                    case ("productName"):
                        return goods.stream().filter(p -> p.getProductName().equals(value1))
                                .filter(p -> p.getProductPrice().equals(Integer.parseInt(value2)))
                                .collect(Collectors.toList());
                    case ("productQuantity"):
                        return goods.stream().filter(p -> p.getProductQuantity().equals(Integer.parseInt(value1)))
                                .filter(p -> p.getProductPrice().equals(Integer.parseInt(value2)))
                                .collect(Collectors.toList());
                    case ("storeName"):
                        return goods.stream().filter(p -> p.getStore().getStoreName().equals(value1))
                                .filter(p -> p.getProductPrice().equals(Integer.parseInt(value2)))
                                .collect(Collectors.toList());
                }
            case ("productQuantity"):
                switch (attribute1) {
                    case ("productProducer"):
                        return goods.stream().filter(p -> p.getProductProducer().equals(value1))
                                .filter(p -> p.getProductQuantity().equals(Integer.parseInt(value2)))
                                .collect(Collectors.toList());
                    case ("productPrice"):
                        return goods.stream().filter(p -> p.getProductPrice().equals(Integer.parseInt(value1)))
                                .filter(p -> p.getProductQuantity().equals(Integer.parseInt(value2)))
                                .collect(Collectors.toList());
                    case ("productQuantity"):
                        return goods.stream().filter(p -> p.getProductName().equals(value1))
                                .filter(p -> p.getProductQuantity().equals(Integer.parseInt(value2)))
                                .collect(Collectors.toList());
                    case ("storeName"):
                        return goods.stream().filter(p -> p.getStore().getStoreName().equals(value1))
                                .filter(p -> p.getProductQuantity().equals(Integer.parseInt(value2)))
                                .collect(Collectors.toList());
                }
            case ("storeName"):
                switch (attribute1) {
                    case ("productProducer"):
                        return goods.stream().filter(p -> p.getProductProducer().equals(value1))
                                .filter(p -> p.getStore().getStoreName().equals(value2))
                                .collect(Collectors.toList());
                    case ("productPrice"):
                        return goods.stream().filter(p -> p.getProductPrice().equals(Integer.parseInt(value1)))
                                .filter(p -> p.getStore().getStoreName().equals(value2))
                                .collect(Collectors.toList());
                    case ("productQuantity"):
                        return goods.stream().filter(p -> p.getProductQuantity().equals(Integer.parseInt(value1)))
                                .filter(p -> p.getStore().getStoreName().equals(value1))
                                .collect(Collectors.toList());
                    case ("storeName"):
                        return goods.stream().filter(p -> p.getProductName().equals(value1))
                                .filter(p -> p.getStore().getStoreName().equals(value2))
                                .collect(Collectors.toList());
                }

            default:
                log.warn(FALSE_CATEGORY_NAME);
                throw new DaoException(FALSE_CATEGORY_NAME);
        }
    }

}
