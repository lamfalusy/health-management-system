package hu.lamsoft.hms.common.service.customer.dto;

import java.util.Date;

import hu.lamsoft.hms.common.persistence.regimen.enums.Meal;
import hu.lamsoft.hms.common.service.dto.BaseDTO;
import hu.lamsoft.hms.common.service.food.dto.FoodDTO;
import hu.lamsoft.hms.common.service.unit.dto.QuantityDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CustomerMealDTO extends BaseDTO {

	private CustomerDTO customer;
	private Meal meal;
	private Date timeOfMeal;
	private QuantityDTO quantity;
	private FoodDTO food;
	
}
