package hu.lamsoft.hms.common.service.food;

import org.springframework.data.domain.Page;

import hu.lamsoft.hms.common.service.food.vo.RecipeSearchVO;
import hu.lamsoft.hms.common.service.food.vo.RecipeVO;

public interface RecipeService {

	Page<RecipeVO> searchRecipe(RecipeSearchVO recipeSearchVO);
	
}
