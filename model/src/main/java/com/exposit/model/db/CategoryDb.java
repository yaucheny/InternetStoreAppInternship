package com.exposit.model.db;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
//@Entity
//@Table(name = "categories")
public class CategoryDb extends BaseDb {

//    @Column(name = "name")
    private String name;

//    @ManyToOne
    private Long parentId;

//    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CategoryDb> childList;

    @Override
    public String toString() {
        return "Category{" + "id=" + id
                + ", name='" + name + '\''
                + ", parentId=" + parentId
                + ", childList=" + childList
                + '}';
    }
}
