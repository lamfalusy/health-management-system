package hu.lamsoft.hms.common.service.regimen.vo;

import java.util.List;

import hu.lamsoft.hms.common.persistence.nutritionist.entity.Nutritionist;
import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenVO extends BaseVO {

	private String name;
	private String description;
	private Nutritionist creator;
	private List<RegimenWeekVO> weeks;
	
}
