package hu.lamsoft.hms.common.service.food;

import java.util.List;

import hu.lamsoft.hms.common.persistence.food.entity.Food;
import hu.lamsoft.hms.common.persistence.recipe.entity.Recipe;
import hu.lamsoft.hms.common.service.food.vo.FoodSearchVO;
import hu.lamsoft.hms.common.service.food.vo.RecipeSearchVO;

public interface FoodService {

	List<Food> searchFood(FoodSearchVO foodSearchVO);
	
	List<Recipe> searchRecipe(RecipeSearchVO recipeSearchVO);
	
}
