package hu.lamsoft.hms.regimen.service.regimen.dto;

import hu.lamsoft.hms.common.service.dto.BaseDTO;
import hu.lamsoft.hms.regimen.persistence.regimen.enums.DaysOfWeek;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenDayToWeekDTO extends BaseDTO {

	private RegimenWeekDTO regimenWeek;
	private RegimenDayDTO regimenDay;
	private DaysOfWeek dayOfWeek;
	
}
