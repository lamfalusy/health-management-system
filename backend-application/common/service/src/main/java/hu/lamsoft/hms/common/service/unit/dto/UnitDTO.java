package hu.lamsoft.hms.common.service.unit.dto;

import hu.lamsoft.hms.common.persistence.unit.enums.UnitType;
import hu.lamsoft.hms.common.service.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class UnitDTO extends BaseDTO {

	private UnitType type;
	private String name;
	private String shortName;
	
}
