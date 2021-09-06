package com.exposit.domain.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * Simple JavaBean object that represents a Customer entity. This additional object is created
 * to work with hibernate and spring data JPA. This object is mapped from Customerdb object
 * {@link com.exposit.domain.model.db.CustomerDb} in dao layer.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class CustomerEntity extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Override
    public String toString() {
        return "Customer{"
                + "id=" + id
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", address='" + address + '\''
                + ", email='" + email + '\''
                + '}';
    }
}
