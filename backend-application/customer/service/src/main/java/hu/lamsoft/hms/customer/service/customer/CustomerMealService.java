package hu.lamsoft.hms.customer.service.customer;

import java.util.Date;
import java.util.List;

import hu.lamsoft.hms.common.persistence.regimen.enums.Meal;
import hu.lamsoft.hms.customer.service.customer.dto.CustomerMealDTO;

public interface CustomerMealService {

	List<Meal> getMeals();
	
	CustomerMealDTO recordCustomerMeal(CustomerMealDTO customerMeal);
	
	List<CustomerMealDTO> getCustomerMeal(String email, Date fromDate, Date toDate);
	
}
