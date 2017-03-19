package hu.lamsoft.hms.common.service.food;

import java.util.List;

import hu.lamsoft.hms.common.service.food.vo.FoodSearchVO;
import hu.lamsoft.hms.common.service.food.vo.FoodVO;
import hu.lamsoft.hms.common.service.food.vo.RecipeSearchVO;
import hu.lamsoft.hms.common.service.food.vo.RecipeVO;

public interface FoodService {

	List<FoodVO> searchFood(FoodSearchVO foodSearchVO);
	
	List<RecipeVO> searchRecipe(RecipeSearchVO recipeSearchVO);
	
}
