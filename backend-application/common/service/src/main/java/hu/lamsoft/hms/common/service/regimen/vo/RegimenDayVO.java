package hu.lamsoft.hms.common.service.regimen.vo;

import java.util.List;

import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenDayVO extends BaseVO {

	private String name;
	private List<RegimenDayMealVO> meals;
	
}