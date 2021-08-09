package com.exposit.model.db;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
//@Entity
//@Table(name = "stores")
public class StoreDb extends BaseDb {
//    @Column(name = "name")
    private String name;
//    @Column(name = "internet_page")
    private String internetPage;
//    @Column(name = "phone_number")
    private String phoneNumber;

    @Override
    public String toString() {
        return "Store{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", internetPage='" + internetPage + '\''
                + ", phoneNumber='" + phoneNumber + '\''
                + '}';
    }
}
