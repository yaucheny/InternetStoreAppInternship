package com.exposit.domain.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * Simple JavaBean object that represents a Store entity. This additional object is created
 * to work with hibernate and spring data JPA. This object is mapped from StoreDb object
 * {@link com.exposit.domain.model.db.StoreDb} in dao layer.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "stores")
public class StoreEntity extends BaseEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "internet_page")
    private String internetPage;
    @Column(name = "phone_number")
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
