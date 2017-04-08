package hu.lamsoft.hms.customer.service.customer.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hu.lamsoft.hms.common.persistence.customer.dao.CustomerDao;
import hu.lamsoft.hms.common.persistence.customer.entity.Customer;
import hu.lamsoft.hms.common.service.customer.dto.CustomerDTO;
import hu.lamsoft.hms.common.service.mapper.ModelMapper;
import hu.lamsoft.hms.customer.service.customer.CustomerService;
import hu.lamsoft.hms.customer.service.customer.exception.EmailAddressAlreadyUsedException;
import hu.lamsoft.hms.customer.service.customer.vo.CustomerRegistrationVO;

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
	public CustomerDTO registrate(CustomerRegistrationVO customerRegistration) {
		if(customerDao.findByEmail(customerRegistration.getEmail()) != null) {
			throw new EmailAddressAlreadyUsedException();
		}
		Customer entity = new Customer();
		entity.setFirstname(customerRegistration.getFirstname());
		entity.setLastname(customerRegistration.getLastname());
		entity.setEmail(customerRegistration.getEmail());
		entity.setBirthday(customerRegistration.getBirthday());
		entity.setPassword(passwordEncoder.encode(customerRegistration.getRawPassword()));
		return modelMapper.convertToDTO(customerDao.save(entity), CustomerDTO.class);
	}

	@Override
	public CustomerDTO getCustomer(String email) {
		return modelMapper.convertToDTO(customerDao.findByEmail(email), CustomerDTO.class);
	}

}
