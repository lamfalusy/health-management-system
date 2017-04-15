package hu.lamsoft.hms.androidclient.restapi.regimen.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;
import hu.lamsoft.hms.androidclient.restapi.food.dto.FoodDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenDayMealItemDTO extends BaseDTO {

	@JsonIgnore
	private RegimenDayMealDTO regimenDayMeal;
	private FoodDTO food;
	
}
