package hu.lamsoft.hms.common.service.regimen.dto;

import java.util.List;

import hu.lamsoft.hms.common.persistence.regimen.enums.Meal;
import hu.lamsoft.hms.common.service.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenDayMealDTO extends BaseDTO {

	private RegimenDayDTO regimenDay;
	private Meal meal;
	private List<RegimenDayMealItemDTO> items;
	
}
