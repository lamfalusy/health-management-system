package hu.lamsoft.hms.common.service.customer;

import hu.lamsoft.hms.common.service.customer.vo.CustomerRegistrationVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerVO;

public interface CustomerService {

	CustomerVO registrate(CustomerRegistrationVO customer);
	
	CustomerVO getCustomer(String email);
	
}
