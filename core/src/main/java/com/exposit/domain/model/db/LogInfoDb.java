package com.exposit.domain.model.db;

import lombok.Data;

@Data
public class LogInfoDb extends BaseDb {

    private String path;
    private Long workTime;
    private Long numberErrors;
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
