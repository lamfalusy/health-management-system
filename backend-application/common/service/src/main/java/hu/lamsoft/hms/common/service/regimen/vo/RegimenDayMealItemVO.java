package hu.lamsoft.hms.common.service.regimen.vo;

import hu.lamsoft.hms.common.service.food.vo.FoodVO;
import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenDayMealItemVO extends BaseVO {

	private RegimenDayMealVO regimenDayMeal;
	private FoodVO food;
	
}
