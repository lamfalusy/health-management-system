package hu.lamsoft.hms.common.service.food;

import org.springframework.data.domain.Page;

import hu.lamsoft.hms.common.service.food.dto.FoodDTO;
import hu.lamsoft.hms.common.service.food.vo.FoodSearchVO;

public interface FoodService {

	Page<FoodDTO> searchFood(FoodSearchVO foodSearchVO);	
	
}
