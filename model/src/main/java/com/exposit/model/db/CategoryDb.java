package com.exposit.model.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
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
}
