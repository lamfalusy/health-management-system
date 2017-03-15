package hu.lamsoft.hms.common.persistence.recipe.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.lamsoft.hms.common.persistence.recipe.entity.Recipe;

@Repository
public interface RecipeDao extends JpaRepository<Recipe, Long> {

}
