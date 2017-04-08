package hu.lamsoft.hms.food.service.food;

import org.springframework.data.domain.Page;

import hu.lamsoft.hms.common.service.food.dto.RecipeDTO;
import hu.lamsoft.hms.food.service.food.vo.RecipeSearchVO;

public interface RecipeService {

	Page<RecipeDTO> searchRecipe(RecipeSearchVO recipeSearchVO);
	
}
