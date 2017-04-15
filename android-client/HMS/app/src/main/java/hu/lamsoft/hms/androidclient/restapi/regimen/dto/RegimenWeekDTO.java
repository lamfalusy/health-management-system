package hu.lamsoft.hms.androidclient.restapi.regimen.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenWeekDTO extends BaseDTO {

	@JsonIgnore
	private RegimenDTO regimen;
	private List<RegimenDayToWeekDTO> regimenDayToWeeks;
	private Integer orderNumber;
	
}
