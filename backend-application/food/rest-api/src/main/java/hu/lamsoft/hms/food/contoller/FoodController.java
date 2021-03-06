package hu.lamsoft.hms.food.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.hms.common.service.food.dto.FoodDTO;
import hu.lamsoft.hms.food.service.food.FoodService;
import hu.lamsoft.hms.food.service.food.vo.FoodSearchVO;

@RestController
public class FoodController {

	@Autowired
	private FoodService foodService;
	
	@RequestMapping(value = "/foods", method = RequestMethod.GET)
    public Page<FoodDTO> getFoods(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
    		@RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        return foodService.searchFood(new FoodSearchVO(page, size));
    }
	
	@RequestMapping(value = "/foods", method = RequestMethod.POST)
    public Page<FoodDTO> getFoods(@RequestBody FoodSearchVO foodSearchVO) {
        return foodService.searchFood(foodSearchVO);
    }
	
}
