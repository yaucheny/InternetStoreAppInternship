package com.exposit.domain.model.db;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
/**
 * Simple JavaBean object that represents a product.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ProductDb extends BaseDb {

    private String name;
    private String producer;
    private List<CategoryDb> categoryList;
}
