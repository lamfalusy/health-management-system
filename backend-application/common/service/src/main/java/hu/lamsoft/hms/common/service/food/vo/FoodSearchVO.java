package hu.lamsoft.hms.common.service.food.vo;

import hu.lamsoft.hms.common.service.search.vo.BaseSearchVO;
import lombok.Getter;

@Getter
public class FoodSearchVO extends BaseSearchVO {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private Double sugarInGGT;
	
	private Double sugarInGLT;
	
	public FoodSearchVO() {
		super(0, 10);
	}
	
	public FoodSearchVO(int page, int size) {
		super(page, size);
	}

	public FoodSearchVO(int page, int size, String name, Double sugarInGGT, Double sugarInGLT) {
		super(page, size);
		this.name = name;
		this.sugarInGGT = sugarInGGT;
		this.sugarInGLT = sugarInGLT;
	}
	
}
