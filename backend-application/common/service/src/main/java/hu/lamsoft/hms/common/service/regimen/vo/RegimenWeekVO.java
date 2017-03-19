package hu.lamsoft.hms.common.service.regimen.vo;

import java.util.List;

import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenWeekVO extends BaseVO {

	private RegimenVO regimen;
	private List<RegimenDayToWeekVO> regimenDayToWeeks;
	private Integer orderNumber;
	
}
