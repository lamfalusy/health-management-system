package hu.lamsoft.hms.common.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.lamsoft.hms.common.persistence.entity.BaseEntity;

public interface BaseDao<T extends BaseEntity> extends JpaRepository<T, Long> {

}
