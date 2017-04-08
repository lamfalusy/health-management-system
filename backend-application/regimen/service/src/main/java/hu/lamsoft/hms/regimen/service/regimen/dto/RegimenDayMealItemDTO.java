package hu.lamsoft.hms.regimen.service.regimen.dto;

import hu.lamsoft.hms.common.service.dto.BaseDTO;
import hu.lamsoft.hms.common.service.food.dto.FoodDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenDayMealItemDTO extends BaseDTO {

	private RegimenDayMealDTO regimenDayMeal;
	private FoodDTO food;
	
}
