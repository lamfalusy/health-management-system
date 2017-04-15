package hu.lamsoft.hms.androidclient.restapi.food.dto;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;
import hu.lamsoft.hms.androidclient.restapi.unit.dto.QuantityDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RecipeComponentDTO extends BaseDTO {

	private FoodDTO food;
	private QuantityDTO quantity;
	
}
