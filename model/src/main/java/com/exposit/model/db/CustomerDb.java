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
//@Table(name = "customers")
public class CustomerDb extends BaseDb {
//    @Column(name = "first_name")
    private String firstName;
//    @Column(name = "last_name")
    private String lastName;
//    @Column(name = "address")
    private String address;
//    @Column(name = "email")
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
