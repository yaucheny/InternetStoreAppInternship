package com.exposit.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Category extends AEntity {
    String nameOfCategory;
    Category parent;
    List<Category> subCategory;

    public Category() {
    }

    public Category(String nameOfCategory, Category parent) {
        this.nameOfCategory = nameOfCategory;
        this.parent = parent;
        this.subCategory= new ArrayList<>();
    }

    public Category(Long id, String nameOfCategory, Category parent) {
        super(id);
        this.nameOfCategory = nameOfCategory;
        this.parent = parent;
    }

    public Category(
            @JsonProperty("id")Long id,
            @JsonProperty("nameOfCategory")String nameOfCategory,
            @JsonProperty("parent")Category parent,
            @JsonProperty("subCategory")List<Category> subCategory) {
        super(id);
        this.nameOfCategory = nameOfCategory;
        this.parent = parent;
        this.subCategory = subCategory;
    }

    public String getNameOfCategory() {
        return nameOfCategory;
    }

    public void setNameOfCategory(String nameOfCategory) {
        this.nameOfCategory = nameOfCategory;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category> getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(List<Category> subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", nameOfCategory='" + nameOfCategory + '\'' +
                ", parent=" + parent +
                ", subCategory=" + subCategory +
                '}';
    }
}
