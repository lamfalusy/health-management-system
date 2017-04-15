package hu.lamsoft.hms.androidclient.restapi.regimen.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;
import hu.lamsoft.hms.androidclient.restapi.regimen.enums.DaysOfWeek;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenDayToWeekDTO extends BaseDTO {

	@JsonIgnore
	private RegimenWeekDTO regimenWeek;
	private RegimenDayDTO regimenDay;
	private DaysOfWeek dayOfWeek;
	
}
