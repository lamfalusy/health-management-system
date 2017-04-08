package hu.lamsoft.hms.common.service.regimen.dto;

import java.util.List;

import hu.lamsoft.hms.common.persistence.nutritionist.entity.Nutritionist;
import hu.lamsoft.hms.common.service.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenDTO extends BaseDTO {

	private String name;
	private String description;
	private Nutritionist creator;
	private List<RegimenWeekDTO> weeks;
	
}
