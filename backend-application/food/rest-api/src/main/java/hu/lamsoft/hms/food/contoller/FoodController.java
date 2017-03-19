package hu.lamsoft.hms.food.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.hms.common.service.food.FoodService;
import hu.lamsoft.hms.common.service.food.vo.FoodVO;

@RestController
public class FoodController {

	@Autowired
	private FoodService foodService;
	
	@RequestMapping(value = "/foods", method = RequestMethod.GET)
    public List<FoodVO> getFoods() {
        return foodService.searchFood(null);
    }
	
}
