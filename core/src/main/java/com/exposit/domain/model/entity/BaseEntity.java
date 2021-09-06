package com.exposit.domain.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Simple JavaBean object that represents a parent entity. This additional object is created
 * to work with hibernate and spring data JPA. This object is mapped from Basedb object
 * {@link com.exposit.domain.model.db.BaseDb} in dao layer.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;
}
