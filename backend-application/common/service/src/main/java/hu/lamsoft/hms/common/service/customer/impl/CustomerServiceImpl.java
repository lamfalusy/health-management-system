package hu.lamsoft.hms.common.service.customer.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.lamsoft.hms.common.persistence.customer.dao.CustomerDao;
import hu.lamsoft.hms.common.persistence.customer.entity.Customer;
import hu.lamsoft.hms.common.persistence.customer.entity.CustomerHistoricalData;
import hu.lamsoft.hms.common.persistence.customer.entity.CustomerHistoricalDataValue;
import hu.lamsoft.hms.common.persistence.customer.entity.CustomerMeal;
import hu.lamsoft.hms.common.service.customer.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Customer registrate(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public Customer getCustomer(String email) {
		return customerDao.findByEmail(email);
	}
	
	@Override
	public CustomerHistoricalDataValue recordHistoricalData(CustomerHistoricalDataValue historicalDataValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerMeal recordCustomerMeal(CustomerMeal customerMeal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerHistoricalDataValue> getHistoricalData(Customer customer, CustomerHistoricalData historicalData, Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerMeal> getCustomerMeal(Customer customer, Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
