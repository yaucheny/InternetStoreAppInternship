package com.exposit.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class StoreEntity extends AEntity {

    private String name;
    private String internetPage;
    private String phoneNumber;

    public StoreEntity(Long id, String name, String internetPage,
                       String phoneNumber) {
        super(id);
        this.name = name;
        this.internetPage = internetPage;
        this.phoneNumber = phoneNumber;
    }

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
