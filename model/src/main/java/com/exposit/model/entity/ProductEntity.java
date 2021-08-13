package com.exposit.model.entity;

import com.exposit.model.api.ProductModel;
import com.exposit.model.db.CategoryDb;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity implements ProductModel {
    @Column(name = "name")
    private String name;
    @Column(name = "producer")
    private String producer;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "products_categories", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<CategoryDb> categoryList;

    @Override
    public String toString() {
        return "Product{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", producer='" + producer + '\''
                + ", categoryList=" + categoryList
                + '}';
    }
}
