package hu.lamsoft.hms.customer.service.customer.dto;

import hu.lamsoft.hms.common.persistence.unit.entity.Unit;
import hu.lamsoft.hms.common.service.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CustomerHistoricalDataDTO extends BaseDTO {

	private String code;
	private Unit unit;
	
}
