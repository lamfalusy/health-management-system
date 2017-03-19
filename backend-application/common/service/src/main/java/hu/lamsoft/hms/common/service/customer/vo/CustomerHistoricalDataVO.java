package hu.lamsoft.hms.common.service.customer.vo;

import hu.lamsoft.hms.common.persistence.unit.entity.Unit;
import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CustomerHistoricalDataVO extends BaseVO {

	private String code;
	private Unit unit;
	
}
