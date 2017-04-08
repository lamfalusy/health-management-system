package hu.lamsoft.hms.common.service.nutritionist.dto;

import hu.lamsoft.hms.common.service.customer.dto.CustomerDTO;
import hu.lamsoft.hms.common.service.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class NutritionistDTO extends BaseDTO {

	private CustomerDTO customer;
	private String introduction;
	
}
