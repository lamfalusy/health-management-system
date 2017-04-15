package hu.lamsoft.hms.androidclient.restapi.regimen.dto;

import java.util.List;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenDayDTO extends BaseDTO {

	private String name;
	private List<RegimenDayMealDTO> meals;
	
}
