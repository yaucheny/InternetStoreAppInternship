package com.exposit.service;

import com.exposit.api.dao.ProductDao;
import com.exposit.api.service.ProductService;
import com.exposit.domain.dto.ProductDto;
import com.exposit.domain.model.db.ProductDb;
import com.exposit.utils.exceptions.DaoException;
import com.exposit.utils.exceptions.NotFoundException;
import com.exposit.utils.exceptions.ServiceException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ModelMapper mapper;
    private final ProductDao productDao;
    private static final String CAN_NOT_DELETE_PRODUCT = "can not delete product";
    private static final String CAN_NOT_UPDATE_PRODUCT = "can not update product";
    private static final String CAN_NOT_ADD_PRODUCT = "can not add product";

    @Override
    public void addProduct(ProductDto productDto) {
        if (productDto.getId() == null) {
            try {
                ProductDb product = mapper.map(productDto, ProductDb.class);
                productDao.save(product);
            } catch (Exception e) {
                LOG.error(CAN_NOT_ADD_PRODUCT);
                throw new ServiceException(CAN_NOT_ADD_PRODUCT,e);
            }
        }
    }

    @Override
    public void deleteProduct(Long id) {
        try {
            productDao.delete(productDao.getById(id));
        } catch (DaoException e) {
            LOG.error(CAN_NOT_DELETE_PRODUCT);
            throw new ServiceException(CAN_NOT_DELETE_PRODUCT, e);
        }
    }

    @Override
    public void updateProduct(Long id, ProductDto productDto) {
        if (productDao.getById(id) != null) {
            try {
                ProductDb product = mapper.map(productDto, ProductDb.class);
                product.setId(id);
                productDao.update(id, product);
            } catch (NotFoundException e) {
                LOG.error(CAN_NOT_UPDATE_PRODUCT);
                throw new ServiceException(CAN_NOT_UPDATE_PRODUCT, e);
            }
        }
    }

    @Override
    public ProductDto getProductById(Long id) {
        ProductDb productDb = productDao.getById(id);
        return mapper.map(productDb, ProductDto.class);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<ProductDb> productDbList = productDao.getAll();
        Type listType = new TypeToken<List<ProductDto>>() {
        }.getType();
        return mapper.map(productDbList, listType);
    }

    @Override
    public void saveProductToFile() {
        productDao.saveToFile(productDao.getAll());
    }
}
