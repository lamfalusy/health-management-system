package hu.lamsoft.hms.common.service.nutritionist.vo;

import hu.lamsoft.hms.common.service.customer.vo.CustomerVO;
import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class NutritionistVO extends BaseVO {

	private CustomerVO customer;
	private String introduction;
	
}
