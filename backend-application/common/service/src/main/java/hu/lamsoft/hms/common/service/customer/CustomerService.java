package hu.lamsoft.hms.common.service.customer;

import java.util.Date;
import java.util.List;

import hu.lamsoft.hms.common.service.customer.vo.CustomerHistoricalDataVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerHistoricalDataValueVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerMealVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerRegistrationVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerVO;

public interface CustomerService {

	CustomerVO registrate(CustomerRegistrationVO customer);
	
	CustomerVO getCustomer(String email);
	
	CustomerHistoricalDataValueVO recordHistoricalData(CustomerHistoricalDataValueVO historicalDataValue);
	
	CustomerMealVO recordCustomerMeal(CustomerMealVO customerMeal);
	
	List<CustomerHistoricalDataValueVO> getHistoricalData(CustomerVO customer, CustomerHistoricalDataVO historicalData, Date fromDate, Date toDate);
	
	List<CustomerMealVO> getCustomerMeal(CustomerVO customer, Date fromDate, Date toDate);
	
}
