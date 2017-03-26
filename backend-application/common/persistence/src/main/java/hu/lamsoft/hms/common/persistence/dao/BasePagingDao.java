package hu.lamsoft.hms.common.persistence.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import hu.lamsoft.hms.common.persistence.entity.BaseEntity;

public interface BasePagingDao<T extends BaseEntity> extends PagingAndSortingRepository<T, Long> {

}
