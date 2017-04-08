package hu.lamsoft.hms.common.service.customer;

import java.util.Date;
import java.util.List;

import hu.lamsoft.hms.common.persistence.regimen.enums.Meal;
import hu.lamsoft.hms.common.service.customer.vo.CustomerMealVO;

public interface CustomerMealService {

	List<Meal> getMeals();
	
	CustomerMealVO recordCustomerMeal(CustomerMealVO customerMeal);
	
	List<CustomerMealVO> getCustomerMeal(String email, Date fromDate, Date toDate);
	
}
