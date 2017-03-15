package hu.lamsoft.hms.food.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.hms.common.persistence.food.entity.Food;
import hu.lamsoft.hms.common.restapi.security.jwt.AuthenticatedUser;
import hu.lamsoft.hms.common.service.food.FoodService;

@RestController
public class FoodController {

	@Autowired
	private FoodService foodService;
	
	@RequestMapping(value = "/foods", method = RequestMethod.GET)
    public List<Food> getFoods(AuthenticatedUser authentication) {
        return foodService.searchFood(null);
    }
	
}
