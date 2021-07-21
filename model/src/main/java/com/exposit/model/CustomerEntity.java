package com.exposit.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity extends AEntity {

    private String firstName;
    private String lastName;
    private String address;
    private String email;


    public CustomerEntity(Long id, String firstName, String lastName,
                          String address, String email) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }

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
