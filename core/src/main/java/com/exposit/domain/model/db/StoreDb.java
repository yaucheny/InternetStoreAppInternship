package com.exposit.domain.model.db;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Simple JavaBean object that represents a Store.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class StoreDb extends BaseDb {

    private String name;
    private String internetPage;
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
