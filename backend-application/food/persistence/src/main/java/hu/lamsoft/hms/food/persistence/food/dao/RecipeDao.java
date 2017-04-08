package hu.lamsoft.hms.food.persistence.food.dao;

import org.springframework.stereotype.Repository;

import hu.lamsoft.hms.common.persistence.dao.BaseSearchDao;
import hu.lamsoft.hms.common.persistence.food.entity.Recipe;

@Repository
public interface RecipeDao extends BaseSearchDao<Recipe> {

}
