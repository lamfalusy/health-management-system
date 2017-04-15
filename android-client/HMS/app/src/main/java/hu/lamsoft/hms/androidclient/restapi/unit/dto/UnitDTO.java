package hu.lamsoft.hms.androidclient.restapi.unit.dto;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;
import hu.lamsoft.hms.androidclient.restapi.unit.enums.UnitType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class UnitDTO extends BaseDTO {

	private UnitType type;
	private String name;
	private String shortName;
	
}
