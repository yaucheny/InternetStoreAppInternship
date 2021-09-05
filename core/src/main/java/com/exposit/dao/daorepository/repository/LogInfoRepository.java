package com.exposit.dao.daorepository.repository;

import com.exposit.domain.model.entity.LogInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogInfoRepository extends JpaRepository<LogInfoEntity,Long> {
}
