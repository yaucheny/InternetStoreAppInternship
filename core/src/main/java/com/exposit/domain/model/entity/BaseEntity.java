package com.exposit.domain.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/**
 * Simple JavaBean object that represents a parent entity. This additional object is created
 * to work with hibernate and spring data JPA. This object is mapped from Basedb object
 * {@link com.exposit.domain.model.db.BaseDb} in dao layer.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Data
@EqualsAndHashCode
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;
}
