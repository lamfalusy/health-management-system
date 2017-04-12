package hu.lamsoft.hms.regimen.service.regimen.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import hu.lamsoft.hms.common.persistence.regimen.enums.Meal;
import hu.lamsoft.hms.common.service.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenDayMealDTO extends BaseDTO {

	@JsonIgnore
	private RegimenDayDTO regimenDay;
	private Meal meal;
	private List<RegimenDayMealItemDTO> items;
	
}
