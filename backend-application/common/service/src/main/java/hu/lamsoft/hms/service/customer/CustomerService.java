package hu.lamsoft.hms.service.customer;

import java.util.Date;
import java.util.List;

import hu.lamsoft.hms.model.customer.Customer;
import hu.lamsoft.hms.model.customer.CustomerHistoricalData;
import hu.lamsoft.hms.model.customer.CustomerHistoricalDataValue;
import hu.lamsoft.hms.model.customer.CustomerMeal;

public interface CustomerService {

	Customer registrate(Customer customer);
	
	CustomerHistoricalDataValue recordHistoricalData(CustomerHistoricalDataValue historicalDataValue);
	
	CustomerMeal recordCustomerMeal(CustomerMeal customerMeal);
	
	List<CustomerHistoricalDataValue> getHistoricalData(Customer customer, CustomerHistoricalData historicalData, Date fromDate, Date toDate);
	
	List<CustomerMeal> getCustomerMeal(Customer customer, Date fromDate, Date toDate);
	
}
