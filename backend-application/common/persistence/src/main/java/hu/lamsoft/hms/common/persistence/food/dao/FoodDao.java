package hu.lamsoft.hms.common.persistence.food.dao;

import org.springframework.stereotype.Repository;

import hu.lamsoft.hms.common.persistence.dao.BaseSearchDao;
import hu.lamsoft.hms.common.persistence.food.entity.Food;

@Repository
public interface FoodDao extends BaseSearchDao<Food> {

}
