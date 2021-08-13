package com.exposite.service;

import com.exposit.api.dao.ProductDao;
import com.exposit.api.service.ProductService;
import com.exposit.dto.ProductDto;
import com.exposit.exceptions.DaoException;
import com.exposit.exceptions.ServiceException;
import com.exposit.marshelling.json.MarshallingProductJson;
import com.exposit.model.db.ProductDb;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Log4j
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ModelMapper mapper;
    private final ProductDao productDao;
    private static final String CAN_NOT_DELETE_PRODUCT = "can not delete product";
    private static final String CAN_NOT_UPDATE_PRODUCT = "can not update product";
    private static final String CAN_NOT_ADD_PRODUCT = "can not add product";

    @Override
    public void addProduct(ProductDto productDto) {
        if (productDto.getId() == null) {
            ProductDb product = mapper.map(productDto, ProductDb.class);
            productDao.save(product);
        } else {
            log.warn(CAN_NOT_ADD_PRODUCT);
            throw new DaoException(CAN_NOT_ADD_PRODUCT);
        }
    }

    @Override
    public void deleteProduct(Long id) {
        try {
            productDao.delete(productDao.getById(id));
        } catch (DaoException e) {
            log.warn(CAN_NOT_DELETE_PRODUCT, e);
            throw new ServiceException(CAN_NOT_DELETE_PRODUCT, e);
        }
    }

    @Override
    public void updateProduct(Long id, ProductDto productDto) {
        if (productDao.getById(id) != null) {
            ProductDb product = mapper.map(productDto, ProductDb.class);
            product.setId(id);
            productDao.update(id, product);
        } else {
            log.warn(CAN_NOT_UPDATE_PRODUCT);
            throw new ServiceException(CAN_NOT_UPDATE_PRODUCT);
        }
    }

    @Override
    public ProductDto getProductById(Long id) {
        ProductDb productDbEntity = productDao.getById(id);
        return mapper.map(productDbEntity, ProductDto.class);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductDb> productDbEntityList = productDao.getAll();
        Type listType = new TypeToken<List<ProductDto>>() {
        }.getType();
        return mapper.map(productDbEntityList, listType);
    }

    @Override
    public void saveProductToFile() {
        MarshallingProductJson.serializeProduct(productDao.getAll());
    }
}
