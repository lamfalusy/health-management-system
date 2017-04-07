package hu.lamsoft.hms.common.service.customer;

import java.util.Date;
import java.util.List;

import hu.lamsoft.hms.common.persistence.regimen.enums.Meal;
import hu.lamsoft.hms.common.service.customer.vo.CustomerHistoricalDataVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerHistoricalDataValueVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerMealVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerRegistrationVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerVO;
import hu.lamsoft.hms.common.service.unit.vo.UnitVO;

public interface CustomerService {

	CustomerVO registrate(CustomerRegistrationVO customer);
	
	CustomerVO getCustomer(String email);
	
	List<CustomerHistoricalDataVO> getHistoricalDatas();
	
	CustomerHistoricalDataValueVO recordHistoricalData(CustomerHistoricalDataValueVO historicalDataValue);
	
	List<Meal> getMeals();
	
	List<UnitVO> getUnits();
	
	CustomerMealVO recordCustomerMeal(CustomerMealVO customerMeal);
	
	List<CustomerHistoricalDataValueVO> getHistoricalData(String email, String historicalDataCode, Date fromDate, Date toDate);
	
	List<CustomerMealVO> getCustomerMeal(String email, Date fromDate, Date toDate);
	
}
