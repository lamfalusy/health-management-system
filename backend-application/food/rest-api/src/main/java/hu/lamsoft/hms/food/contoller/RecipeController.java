package hu.lamsoft.hms.food.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.hms.common.service.food.dto.RecipeDTO;
import hu.lamsoft.hms.food.service.food.RecipeService;
import hu.lamsoft.hms.food.service.food.vo.RecipeSearchVO;

@RestController
public class RecipeController {

	@Autowired
	private RecipeService recipeService;
	
	@RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public Page<RecipeDTO> getFoods(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
    		@RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        return recipeService.searchRecipe(new RecipeSearchVO(page, size));
    }
	
	@RequestMapping(value = "/recipes", method = RequestMethod.POST)
    public Page<RecipeDTO> getFoods(@RequestBody RecipeSearchVO foodSearchVO) {
        return recipeService.searchRecipe(foodSearchVO);
    }
	
}
