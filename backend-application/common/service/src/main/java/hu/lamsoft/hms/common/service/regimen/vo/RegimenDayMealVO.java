package hu.lamsoft.hms.common.service.regimen.vo;

import java.util.List;

import hu.lamsoft.hms.common.persistence.regimen.enums.Meal;
import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenDayMealVO extends BaseVO {

	private RegimenDayVO regimenDay;
	private Meal meal;
	private List<RegimenDayMealItemVO> items;
	
}
