package hu.lamsoft.hms.common.service.food.dto;

import hu.lamsoft.hms.common.service.dto.BaseDTO;
import hu.lamsoft.hms.common.service.unit.dto.QuantityDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RecipeComponentDTO extends BaseDTO {

	private RecipeDTO recipe;
	private FoodDTO food;
	private QuantityDTO quantity;
	
}
