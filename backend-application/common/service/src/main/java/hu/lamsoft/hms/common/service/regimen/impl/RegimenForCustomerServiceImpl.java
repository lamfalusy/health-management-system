package hu.lamsoft.hms.common.service.regimen.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.lamsoft.hms.common.persistence.customer.dao.CustomerDao;
import hu.lamsoft.hms.common.persistence.customer.entity.Customer;
import hu.lamsoft.hms.common.persistence.regimen.dao.RegimenDao;
import hu.lamsoft.hms.common.persistence.regimen.dao.RegimenForCustomerDao;
import hu.lamsoft.hms.common.persistence.regimen.entity.Regimen;
import hu.lamsoft.hms.common.persistence.regimen.entity.RegimenForCustomer;
import hu.lamsoft.hms.common.service.customer.dto.CustomerDTO;
import hu.lamsoft.hms.common.service.mapper.ModelMapper;
import hu.lamsoft.hms.common.service.regimen.RegimenForCustomerService;
import hu.lamsoft.hms.common.service.regimen.dto.RegimenDTO;
import hu.lamsoft.hms.common.service.regimen.dto.RegimenForCustomerDTO;

@Service
@Transactional
public class RegimenForCustomerServiceImpl implements RegimenForCustomerService {

	@Autowired
	private RegimenDao regimenDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private RegimenForCustomerDao regimenForCustomerDao;
	
	@Autowired
	private ModelMapper modelMapper;	
	
	@Override
	public RegimenForCustomerDTO assignRegimenToCustomer(RegimenDTO regimen, CustomerDTO customer) {
		Assert.notNull(regimen);
		Assert.notNull(customer);
		Regimen regimenEntity = regimenDao.findOne(regimen.getId());
		Assert.notNull(regimenEntity);
		Customer customerEntity = customerDao.findOne(customer.getId());
		Assert.notNull(customerEntity);
		RegimenForCustomer entity = new RegimenForCustomer();
		entity.setCustomer(customerEntity);
		entity.setRegimen(regimenEntity);
		entity.setStartDate(new Date());
		return modelMapper.convertToDTO(regimenForCustomerDao.save(entity), RegimenForCustomerDTO.class);
	}

	@Override
	public RegimenForCustomerDTO unAssignRegimenToCustomer(RegimenForCustomerDTO regimenForCustomer, CustomerDTO customer) {
		Assert.notNull(regimenForCustomer);
		Assert.notNull(customer);
		RegimenForCustomer entity = regimenForCustomerDao.findOne(regimenForCustomer.getId());
		Assert.notNull(entity);
		Assert.isTrue(entity.getCustomer().getId().equals(customer.getId()), "Access denied for regimen for customer.");
		Assert.isNull(entity.getEndDate(), "Regimen for customer is already unassigned.");
		entity.setEndDate(new Date());
		return modelMapper.convertToDTO(regimenForCustomerDao.save(entity), RegimenForCustomerDTO.class);
	}

	@Override
	public List<RegimenForCustomerDTO> getRegimenForCustomer(String email) {
		return modelMapper.convertToDTO(regimenForCustomerDao.findByCustomerEmail(email), RegimenForCustomerDTO.class);
	}

}
