package hu.lamsoft.hms.androidclient.restapi.regimen.dto;

import java.util.List;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;
import hu.lamsoft.hms.androidclient.restapi.nutritionist.dto.NutritionistDTO;
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
