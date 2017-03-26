package hu.lamsoft.hms.common.persistence.nutritionist.dao;

import org.springframework.stereotype.Repository;

import hu.lamsoft.hms.common.persistence.customer.entity.Customer;
import hu.lamsoft.hms.common.persistence.dao.BaseSearchDao;
import hu.lamsoft.hms.common.persistence.nutritionist.entity.Nutritionist;

@Repository
public interface NutritionistDao extends BaseSearchDao<Nutritionist> {

	Nutritionist findByCustomer(Customer customer);
	
}
