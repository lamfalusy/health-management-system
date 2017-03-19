package hu.lamsoft.hms.common.service.customer.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hu.lamsoft.hms.common.persistence.customer.dao.CustomerDao;
import hu.lamsoft.hms.common.persistence.customer.entity.Customer;
import hu.lamsoft.hms.common.service.customer.CustomerService;
import hu.lamsoft.hms.common.service.customer.exception.EmailAddressAlreadyUsedException;
import hu.lamsoft.hms.common.service.customer.vo.CustomerHistoricalDataVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerHistoricalDataValueVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerMealVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerRegistrationVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerVO;
import hu.lamsoft.hms.common.service.mapper.ModelMapper;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CustomerVO registrate(CustomerRegistrationVO customerRegistration) {
		if(customerDao.findByEmail(customerRegistration.getEmail()) != null) {
			throw new EmailAddressAlreadyUsedException();
		}
		Customer entity = new Customer();
		entity.setFirstname(customerRegistration.getFirstname());
		entity.setLastname(customerRegistration.getLastname());
		entity.setEmail(customerRegistration.getEmail());
		entity.setBirthday(customerRegistration.getBirthday());
		entity.setPassword(passwordEncoder.encode(customerRegistration.getRawPassword()));
		return modelMapper.convertToVO(customerDao.save(entity), CustomerVO.class);
	}

	@Override
	public CustomerVO getCustomer(String email) {
		return modelMapper.convertToVO(customerDao.findByEmail(email), CustomerVO.class);
	}
	
	@Override
	public CustomerHistoricalDataValueVO recordHistoricalData(CustomerHistoricalDataValueVO historicalDataValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerMealVO recordCustomerMeal(CustomerMealVO customerMeal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerHistoricalDataValueVO> getHistoricalData(CustomerVO customer, CustomerHistoricalDataVO historicalData, Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerMealVO> getCustomerMeal(CustomerVO customer, Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
