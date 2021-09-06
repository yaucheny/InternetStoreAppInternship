package com.exposit.domain.model.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;
/**
 * Simple JavaBean object that represents a Category.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class CategoryDb extends BaseDb {

    private String name;

    private Long parentId;

    @JsonIgnore
    private List<CategoryDb> childList;

    @Override
    public String toString() {
        return "Category{" + "id=" + id
                + ", name='" + name + '\''
                + ", childList=" + childList
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryDb)) return false;
        CategoryDb that = (CategoryDb) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(parentId, that.parentId) &&
                Objects.equals(childList, that.childList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parentId, childList);
    }
}
