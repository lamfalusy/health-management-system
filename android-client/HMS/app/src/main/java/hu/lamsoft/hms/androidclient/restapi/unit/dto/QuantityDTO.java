package hu.lamsoft.hms.androidclient.restapi.unit.dto;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;
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
