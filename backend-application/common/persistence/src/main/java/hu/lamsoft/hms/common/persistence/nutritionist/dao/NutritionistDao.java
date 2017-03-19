package hu.lamsoft.hms.common.persistence.nutritionist.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.lamsoft.hms.common.persistence.customer.entity.Customer;
import hu.lamsoft.hms.common.persistence.nutritionist.entity.Nutritionist;

@Repository
public interface NutritionistDao extends JpaRepository<Nutritionist, Long> {

	Nutritionist findByCustomer(Customer customer);
	
}
