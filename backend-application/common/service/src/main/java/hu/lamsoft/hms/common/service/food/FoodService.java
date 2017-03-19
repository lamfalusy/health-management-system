package hu.lamsoft.hms.common.service.food;

import org.springframework.data.domain.Page;

import hu.lamsoft.hms.common.service.food.vo.FoodSearchVO;
import hu.lamsoft.hms.common.service.food.vo.FoodVO;
import hu.lamsoft.hms.common.service.food.vo.RecipeSearchVO;
import hu.lamsoft.hms.common.service.food.vo.RecipeVO;

public interface FoodService {

	Page<FoodVO> searchFood(FoodSearchVO foodSearchVO);
	
	Page<RecipeVO> searchRecipe(RecipeSearchVO recipeSearchVO);
	
}
