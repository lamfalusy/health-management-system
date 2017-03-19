package hu.lamsoft.hms.common.service.unit.vo;

import hu.lamsoft.hms.common.persistence.unit.enums.UnitType;
import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class UnitVO extends BaseVO {

	private UnitType type;
	private String name;
	private String shortName;
	
}
