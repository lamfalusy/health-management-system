package hu.lamsoft.hms.androidclient.restapi.regimen.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;
import hu.lamsoft.hms.androidclient.restapi.regimen.enums.Meal;
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
