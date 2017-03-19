package hu.lamsoft.hms.common.service.food.vo;

import org.springframework.data.domain.PageRequest;

public class FoodSearchVO extends PageRequest {

	private static final long serialVersionUID = 1L;

	public FoodSearchVO(int page, int size) {
		super(page, size);
	}
	
}
