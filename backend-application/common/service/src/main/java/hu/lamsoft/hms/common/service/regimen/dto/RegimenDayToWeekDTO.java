package hu.lamsoft.hms.common.service.regimen.dto;

import hu.lamsoft.hms.common.persistence.regimen.enums.DaysOfWeek;
import hu.lamsoft.hms.common.service.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenDayToWeekDTO extends BaseDTO {

	private RegimenWeekDTO regimenWeek;
	private RegimenDayDTO regimenDay;
	private DaysOfWeek dayOfWeek;
	
}
