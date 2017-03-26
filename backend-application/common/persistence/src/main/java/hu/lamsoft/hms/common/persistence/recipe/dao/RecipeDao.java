package hu.lamsoft.hms.common.persistence.recipe.dao;

import org.springframework.stereotype.Repository;

import hu.lamsoft.hms.common.persistence.dao.BaseSearchDao;
import hu.lamsoft.hms.common.persistence.recipe.entity.Recipe;

@Repository
public interface RecipeDao extends BaseSearchDao<Recipe> {

}
