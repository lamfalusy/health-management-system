package hu.lamsoft.hms.food.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.hms.common.service.food.FoodService;
import hu.lamsoft.hms.common.service.food.vo.RecipeSearchVO;
import hu.lamsoft.hms.common.service.food.vo.RecipeVO;

@RestController
public class RecipeController {

	@Autowired
	private FoodService foodService;
	
	@RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public Page<RecipeVO> getFoods(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
    		@RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        return foodService.searchRecipe(new RecipeSearchVO(page, size));
    }
	
	@RequestMapping(value = "/recipes", method = RequestMethod.POST)
    public Page<RecipeVO> getFoods(@RequestBody RecipeSearchVO foodSearchVO) {
        return foodService.searchRecipe(foodSearchVO);
    }
	
}
