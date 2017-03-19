package hu.lamsoft.hms.common.service.customer.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CustomerRegistrationVO extends CustomerVO {

	private String rawPassword;
	
}
