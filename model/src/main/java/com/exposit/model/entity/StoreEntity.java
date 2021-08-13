package com.exposit.model.entity;

import com.exposit.model.api.StoreModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "stores")
public class StoreEntity extends BaseEntity implements StoreModel {
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
