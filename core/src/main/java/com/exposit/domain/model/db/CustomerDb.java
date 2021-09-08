package com.exposit.domain.model.db;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Simple JavaBean object that represents a Customer.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerDb extends BaseDb {

    private String firstName;
    private String lastName;
    private String address;
    private String email;
}
