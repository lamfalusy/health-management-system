package hu.lamsoft.hms.common.persistence.customer.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import hu.lamsoft.hms.common.persistence.customer.entity.CustomerMeal;
import hu.lamsoft.hms.common.persistence.dao.BaseDao;

@Repository
public interface CustomerMealDao extends BaseDao<CustomerMeal> {

	List<CustomerMeal> findByCustomerEmailAndTimeOfMealBetween(String customerEmail, Date timeOfMealFrom, Date timeOfMealTo);
	
}
