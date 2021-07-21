package com.exposit.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity extends AEntity {
    private String name;
    private String producer;
    private List<CategoryEntity> categoryList;


    public ProductEntity(Long id, String name, String producer,
                         List<CategoryEntity> categoryList) {
        super(id);
        this.name = name;
        this.producer = producer;
        this.categoryList = categoryList;
    }

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
