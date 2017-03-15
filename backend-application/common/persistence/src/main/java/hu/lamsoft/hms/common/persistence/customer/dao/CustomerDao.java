package hu.lamsoft.hms.common.persistence.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.lamsoft.hms.common.persistence.customer.entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

	Customer findByEmail(String email);
	
}
