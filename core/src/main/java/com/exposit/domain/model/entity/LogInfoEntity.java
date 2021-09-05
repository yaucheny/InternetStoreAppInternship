package com.exposit.domain.model.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
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

    @Override
    public String toString() {
        return "ForLogInfoEntity{"
                + ", id=" + id
                + "path='" + path + '\''
                + ", time=" + workTime
                + ", errorString=" + numberErrors
                + ", updateString=" + numberUpdates
                + '}';
    }
}
