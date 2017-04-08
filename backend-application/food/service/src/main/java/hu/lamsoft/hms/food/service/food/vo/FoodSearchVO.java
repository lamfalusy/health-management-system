package hu.lamsoft.hms.food.service.food.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import hu.lamsoft.hms.common.service.search.vo.BaseSearchVO;
import lombok.Getter;

@Getter
public class FoodSearchVO extends BaseSearchVO {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private Double energyInKcalGT;
	
	private Double energyInKcalLT;
	
	private Double energyInKjGT;
	
	private Double energyInKjLT;
    
	private Double waterInGGT;
    
	private Double waterInGLT;
    
	private Double proteinInGGT;
    
	private Double proteinInGLT;
    
	private Double carbohydratesInGGT;
    
	private Double carbohydratesInGLT;
	
	private Double sugarInGGT;
	
	private Double sugarInGLT;

    private Double fatInGGT;
    
    private Double fatInGLT;
    
    private Double saturatedFatInGGT;
    
    private Double saturatedFatInGLT;
    
    private Double monounsaturatedFatInGGT;
    
    private Double monounsaturatedFatInGLT;
    
    private Double polyunsaturatedFatInGGT;
    
    private Double polyunsaturatedFatInGLT;
    
    private Double cholesterolInMgGT;
    
    private Double cholesterolInMgLT;
    
    private Double fiberInGGT;
    
    private Double fiberInGLT;
    
    private Double emotionalGT;
    
    private Double emotionalLT;
    
    private Double healthyGT;
    
    private Double healthyLT;
    
    private Boolean hasRecipe;
	
	@JsonCreator
	public FoodSearchVO(@JsonProperty("page") int page,@JsonProperty("size") int size) {
		super(page, size);
	}
	
}
