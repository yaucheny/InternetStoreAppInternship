package com.exposit.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CategoryEntity extends AEntity {
    private String name;
    private Long parentId;
    private List<CategoryEntity> childList;

    public CategoryEntity(String name, Long parentId) {
        this.name = name;
        this.parentId = parentId;
    }

    public CategoryEntity(Long id, String name, Long parentId) {
        super(id);
        this.name = name;
        this.parentId = parentId;
    }

    public CategoryEntity(
            Long id,
            String name,
            Long parentId,
            List<CategoryEntity> childList) {
        super(id);
        this.name = name;
        this.parentId = parentId;
        this.childList = childList;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id
                + ", name='" + name + '\''
                + ", parentId=" + parentId
                + ", childList=" + childList
                + '}';
    }
}
