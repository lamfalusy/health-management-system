package hu.lamsoft.hms.customer.persistence.customer.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import hu.lamsoft.hms.common.persistence.dao.BaseDao;
import hu.lamsoft.hms.customer.persistence.customer.entity.CustomerMeal;

@Repository
public interface CustomerMealDao extends BaseDao<CustomerMeal> {

	List<CustomerMeal> findByCustomerEmailAndTimeOfMealBetween(String customerEmail, Date timeOfMealFrom, Date timeOfMealTo);
	
}
