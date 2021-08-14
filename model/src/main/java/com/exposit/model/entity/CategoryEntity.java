package com.exposit.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne
    private CategoryEntity parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<CategoryEntity> childList;

    @Override
    public String toString() {
        return "Category{" + "id=" + id
                + ", name='" + name + '\''
                + ", parentCategory=" + parent
                + ", childList=" + childList
                + '}';
    }
}
