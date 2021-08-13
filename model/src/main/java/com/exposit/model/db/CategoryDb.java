package com.exposit.model.db;

import com.exposit.model.api.CategoryModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "categories")
public class CategoryDb extends BaseDb implements CategoryModel {

    @Column(name = "name")
    private String name;

    @Transient
    @JsonProperty("parentId")
    private Long idOfParent;

    @JsonIgnore
    @ManyToOne
    private CategoryDb parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CategoryDb> childList;

    @Override
    public String toString() {
        return "Category{" + "id=" + id
                + ", name='" + name + '\''
                + ", parent=" + parent
                + ", childList=" + childList
                + '}';
    }
}
