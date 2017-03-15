package hu.lamsoft.hms.common.service.customer;

import java.util.Date;
import java.util.List;

import hu.lamsoft.hms.common.persistence.customer.entity.Customer;
import hu.lamsoft.hms.common.persistence.customer.entity.CustomerHistoricalData;
import hu.lamsoft.hms.common.persistence.customer.entity.CustomerHistoricalDataValue;
import hu.lamsoft.hms.common.persistence.customer.entity.CustomerMeal;

public interface CustomerService {

	Customer registrate(Customer customer);
	
	Customer getCustomer(String email);
	
	CustomerHistoricalDataValue recordHistoricalData(CustomerHistoricalDataValue historicalDataValue);
	
	CustomerMeal recordCustomerMeal(CustomerMeal customerMeal);
	
	List<CustomerHistoricalDataValue> getHistoricalData(Customer customer, CustomerHistoricalData historicalData, Date fromDate, Date toDate);
	
	List<CustomerMeal> getCustomerMeal(Customer customer, Date fromDate, Date toDate);
	
}
