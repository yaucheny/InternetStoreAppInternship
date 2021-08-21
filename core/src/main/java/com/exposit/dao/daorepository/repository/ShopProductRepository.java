package com.exposit.dao.daorepository.repository;

import com.exposit.domain.model.entity.ShopProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopProductRepository extends JpaRepository<ShopProductEntity, Long> {
}
