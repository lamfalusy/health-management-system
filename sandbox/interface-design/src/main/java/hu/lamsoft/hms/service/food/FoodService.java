package hu.lamsoft.hms.service.food;

import java.util.List;

import hu.lamsoft.hms.model.food.Food;
import hu.lamsoft.hms.model.recipe.Recipe;
import hu.lamsoft.hms.service.food.vo.FoodSearchVO;
import hu.lamsoft.hms.service.food.vo.RecipeSearchVO;

public interface FoodService {

	List<Food> searchFood(FoodSearchVO foodSearchVO);
	
	List<Recipe> searchRecipe(RecipeSearchVO recipeSearchVO);
	
}
