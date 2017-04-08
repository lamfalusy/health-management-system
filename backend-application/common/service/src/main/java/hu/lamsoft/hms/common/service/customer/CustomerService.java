package hu.lamsoft.hms.common.service.customer;

import hu.lamsoft.hms.common.service.customer.dto.CustomerDTO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerRegistrationVO;

public interface CustomerService {

	CustomerDTO registrate(CustomerRegistrationVO customer);
	
	CustomerDTO getCustomer(String email);
	
}
