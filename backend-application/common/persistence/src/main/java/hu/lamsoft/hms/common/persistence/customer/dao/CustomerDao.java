package hu.lamsoft.hms.common.persistence.customer.dao;

import org.springframework.stereotype.Repository;

import hu.lamsoft.hms.common.persistence.customer.entity.Customer;
import hu.lamsoft.hms.common.persistence.dao.BaseDao;

@Repository
public interface CustomerDao extends BaseDao<Customer> {

	Customer findByEmail(String email);
	
}
