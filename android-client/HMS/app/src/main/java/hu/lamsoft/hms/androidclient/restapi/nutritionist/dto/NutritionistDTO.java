package hu.lamsoft.hms.androidclient.restapi.nutritionist.dto;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;
import hu.lamsoft.hms.androidclient.restapi.customer.dto.CustomerDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class NutritionistDTO extends BaseDTO {

	private CustomerDTO customer;
	private String introduction;
	
}
