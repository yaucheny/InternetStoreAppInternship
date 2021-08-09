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
//@Table(name = "products")
public class ProductDb extends BaseDb {
//    @Column(name = "name")
    private String name;
//    @Column(name = "producer")
    private String producer;
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
    private List<CategoryDb> categoryList;

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
