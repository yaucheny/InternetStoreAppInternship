package com.exposit.domain.model.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Simple JavaBean object that represents a Category.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class CategoryDb extends BaseDb {

    private String name;

    private Long parentId;

    @JsonIgnore
    private List<CategoryDb> childList;
}
