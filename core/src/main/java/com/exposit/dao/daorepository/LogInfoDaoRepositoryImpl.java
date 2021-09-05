package com.exposit.dao.daorepository;

import com.exposit.api.dao.LogInfoDao;
import com.exposit.dao.daorepository.repository.LogInfoRepository;
import com.exposit.domain.model.db.LogInfoDb;
import com.exposit.domain.model.entity.LogInfoEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Repository
public class LogInfoDaoRepositoryImpl implements LogInfoDao {

    private static final Logger LOG = LoggerFactory.getLogger(LogInfoDaoRepositoryImpl.class);

    private final LogInfoRepository logInfoRepository;
    private final ModelMapper mapper;

    @Override
    @Transactional
    public void save(LogInfoDb logInfoDb) {
        if (logInfoDb.getId() == null) {
            LogInfoEntity logInfoEntity = mapper.map(logInfoDb, LogInfoEntity.class);
            logInfoRepository.save(logInfoEntity);
        }
    }
}
