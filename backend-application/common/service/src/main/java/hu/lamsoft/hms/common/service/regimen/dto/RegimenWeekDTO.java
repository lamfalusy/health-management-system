package hu.lamsoft.hms.common.service.regimen.dto;

import java.util.List;

import hu.lamsoft.hms.common.service.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenWeekDTO extends BaseDTO {

	private RegimenDTO regimen;
	private List<RegimenDayToWeekDTO> regimenDayToWeeks;
	private Integer orderNumber;
	
}
