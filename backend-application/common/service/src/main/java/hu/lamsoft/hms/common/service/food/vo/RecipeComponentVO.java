package hu.lamsoft.hms.common.service.food.vo;

import hu.lamsoft.hms.common.persistence.food.entity.Food;
import hu.lamsoft.hms.common.persistence.unit.entity.Quantity;
import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RecipeComponentVO extends BaseVO {

	private RecipeVO recipe;
	private Food food;
	private Quantity quantity;
	
}
