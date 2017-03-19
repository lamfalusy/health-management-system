package hu.lamsoft.hms.common.service.unit.vo;

import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class QuantityVO extends BaseVO {

	private UnitVO unit;
	private Long longValue;
	private String stringValue;
	private Double doubleValue;
	
}
