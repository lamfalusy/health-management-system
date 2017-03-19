package hu.lamsoft.hms.common.service.regimen.vo;

import hu.lamsoft.hms.common.persistence.regimen.enums.DaysOfWeek;
import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenDayToWeekVO extends BaseVO {

	private RegimenWeekVO regimenWeek;
	private RegimenDayVO regimenDay;
	private DaysOfWeek dayOfWeek;
	
}
