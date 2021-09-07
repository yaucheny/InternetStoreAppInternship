package com.exposit.domain.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
/**
 * Simple JavaBean object that represents a Product entity. This additional object is created
 * to work with hibernate and spring data JPA. This object is mapped from Productdb object
 * {@link com.exposit.domain.model.db.ProductDb} in dao layer.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "producer")
    private String producer;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinTable(name = "products_categories", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CategoryEntity> categoryList;
}
