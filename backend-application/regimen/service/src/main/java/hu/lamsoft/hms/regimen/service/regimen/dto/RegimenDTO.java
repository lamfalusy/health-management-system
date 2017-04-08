package hu.lamsoft.hms.regimen.service.regimen.dto;

import java.util.List;

import hu.lamsoft.hms.common.service.dto.BaseDTO;
import hu.lamsoft.hms.common.service.nutritionist.dto.NutritionistDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenDTO extends BaseDTO {

	private String name;
	private String description;
	private NutritionistDTO creator;
	private List<RegimenWeekDTO> weeks;
	
}
