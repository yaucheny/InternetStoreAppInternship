package com.exposit.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CategoryEntity extends AEntity {
    private String name;
    private Long parentId;
    private List<CategoryEntity> childList;

    @Override
    public String toString() {
        return "Category{" + "id=" + id
                + ", name='" + name + '\''
                + ", parentId=" + parentId
                + ", childList=" + childList
                + '}';
    }
}
