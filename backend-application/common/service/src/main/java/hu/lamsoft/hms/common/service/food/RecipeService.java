package hu.lamsoft.hms.common.service.food;

import org.springframework.data.domain.Page;

import hu.lamsoft.hms.common.service.food.dto.RecipeDTO;
import hu.lamsoft.hms.common.service.food.vo.RecipeSearchVO;

public interface RecipeService {

	Page<RecipeDTO> searchRecipe(RecipeSearchVO recipeSearchVO);
	
}
