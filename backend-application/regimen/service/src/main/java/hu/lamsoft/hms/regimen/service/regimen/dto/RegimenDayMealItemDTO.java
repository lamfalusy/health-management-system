package hu.lamsoft.hms.regimen.service.regimen.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import hu.lamsoft.hms.common.service.dto.BaseDTO;
import hu.lamsoft.hms.common.service.food.dto.FoodDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenDayMealItemDTO extends BaseDTO {

	@JsonIgnore
	private RegimenDayMealDTO regimenDayMeal;
	private FoodDTO food;
	
}
