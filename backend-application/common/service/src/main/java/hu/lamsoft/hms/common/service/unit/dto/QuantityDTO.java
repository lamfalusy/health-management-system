package hu.lamsoft.hms.common.service.unit.dto;

import hu.lamsoft.hms.common.service.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class QuantityDTO extends BaseDTO {

	private UnitDTO unit;
	private Long longValue;
	private String stringValue;
	private Double doubleValue;
	
}
