package hu.lamsoft.hms.common.service.nutritionist.vo;

import hu.lamsoft.hms.common.persistence.customer.entity.Customer;
import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class NutritionistVO extends BaseVO {

	private Customer customer;
	private String introduction;
	
}
