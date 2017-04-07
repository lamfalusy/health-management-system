package hu.lamsoft.hms.common.service.customer.vo;

import java.util.Date;

import hu.lamsoft.hms.common.persistence.regimen.enums.Meal;
import hu.lamsoft.hms.common.service.food.vo.FoodVO;
import hu.lamsoft.hms.common.service.unit.vo.QuantityVO;
import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CustomerMealVO extends BaseVO {

	private CustomerVO customer;
	private Meal meal;
	private Date timeOfMeal;
	private QuantityVO quantity;
	private FoodVO food;
	
}
