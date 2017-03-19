package hu.lamsoft.hms.common.service.customer.vo;

import java.util.Date;

import hu.lamsoft.hms.common.persistence.food.entity.Food;
import hu.lamsoft.hms.common.persistence.regimen.enums.Meal;
import hu.lamsoft.hms.common.persistence.unit.entity.Quantity;
import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CustomerMealVO extends BaseVO {

	private CustomerVO customer;
	private Meal meal;
	private Date timeOfMeal;
	private Quantity quantity;
	private Food food;
	
}
