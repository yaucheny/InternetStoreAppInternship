package com.exposit.domain.model.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Simple JavaBean object that represents a LogInfo entity. This additional object is created
 * to work with hibernate and spring data JPA. This object is mapped from LogInfodb object
 * {@link com.exposit.domain.model.db.LogInfoDb} in dao layer.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "logs")
public class LogInfoEntity extends BaseEntity {

    @Column(name = "file_path")
    private String path;

    @Column(name = "work_time")
    private Long workTime;

    @Column(name = "number_error")
    private Long numberErrors;

    @Column(name = "number_update")
    private Long numberUpdates;
}
