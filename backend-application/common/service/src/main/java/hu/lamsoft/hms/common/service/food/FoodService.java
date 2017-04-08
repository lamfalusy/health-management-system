package hu.lamsoft.hms.common.service.food;

import org.springframework.data.domain.Page;

import hu.lamsoft.hms.common.service.food.vo.FoodSearchVO;
import hu.lamsoft.hms.common.service.food.vo.FoodVO;

public interface FoodService {

	Page<FoodVO> searchFood(FoodSearchVO foodSearchVO);	
	
}
