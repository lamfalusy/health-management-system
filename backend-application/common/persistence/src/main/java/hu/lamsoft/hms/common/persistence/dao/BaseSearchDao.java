package hu.lamsoft.hms.common.persistence.dao;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import hu.lamsoft.hms.common.persistence.entity.BaseEntity;

public interface BaseSearchDao<T extends BaseEntity> extends PagingAndSortingRepository<T, Long>, QueryDslPredicateExecutor<T>{

}
