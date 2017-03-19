package hu.lamsoft.hms.common.persistence.food.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import hu.lamsoft.hms.common.persistence.food.entity.Food;

@Repository
public interface FoodDao extends PagingAndSortingRepository<Food, Long> {

}
