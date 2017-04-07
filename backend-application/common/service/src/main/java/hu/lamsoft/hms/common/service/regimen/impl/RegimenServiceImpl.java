package hu.lamsoft.hms.common.service.regimen.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import hu.lamsoft.hms.common.persistence.customer.dao.CustomerDao;
import hu.lamsoft.hms.common.persistence.customer.entity.Customer;
import hu.lamsoft.hms.common.persistence.regimen.dao.RegimenDao;
import hu.lamsoft.hms.common.persistence.regimen.dao.RegimenForCustomerDao;
import hu.lamsoft.hms.common.persistence.regimen.entity.Regimen;
import hu.lamsoft.hms.common.persistence.regimen.entity.RegimenForCustomer;
import hu.lamsoft.hms.common.service.customer.vo.CustomerVO;
import hu.lamsoft.hms.common.service.mapper.ModelMapper;
import hu.lamsoft.hms.common.service.regimen.RegimenService;
import hu.lamsoft.hms.common.service.regimen.vo.RegimenForCustomerVO;
import hu.lamsoft.hms.common.service.regimen.vo.RegimenSearchVO;
import hu.lamsoft.hms.common.service.regimen.vo.RegimenVO;
import hu.lamsoft.hms.common.service.search.impl.SearchPredicateBuilderComponent;

@Service
@Transactional
public class RegimenServiceImpl implements RegimenService {

	@Autowired
	private RegimenDao regimenDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private RegimenForCustomerDao regimenForCustomerDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private SearchPredicateBuilderComponent searchPredicateBuilderComponent;	
	
	@Override
	public Page<RegimenVO> searchRegimen(RegimenSearchVO regimenSearchVO) {
		return modelMapper.convertToVO(regimenDao.findAll(searchPredicateBuilderComponent.build(regimenSearchVO, RegimenSearchVO.class), regimenSearchVO), RegimenVO.class);
	}

	@Override
	public RegimenForCustomerVO assignRegimenToCustomer(RegimenVO regimen, CustomerVO customer) {
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
		return modelMapper.convertToVO(regimenForCustomerDao.save(entity), RegimenForCustomerVO.class);
	}

	@Override
	public RegimenForCustomerVO unAssignRegimenToCustomer(RegimenForCustomerVO regimenForCustomer, CustomerVO customer) {
		Assert.notNull(regimenForCustomer);
		Assert.notNull(customer);
		RegimenForCustomer entity = regimenForCustomerDao.findOne(regimenForCustomer.getId());
		Assert.notNull(entity);
		Assert.isTrue(entity.getCustomer().getId().equals(customer.getId()), "Access denied for regimen for customer.");
		Assert.isNull(entity.getEndDate(), "Regimen for customer is already unassigned.");
		entity.setEndDate(new Date());
		return modelMapper.convertToVO(regimenForCustomerDao.save(entity), RegimenForCustomerVO.class);
	}

	@Override
	public List<RegimenForCustomerVO> getRegimenForCustomer(String email) {
		return modelMapper.convertToVO(regimenForCustomerDao.findByCustomerEmail(email), RegimenForCustomerVO.class);
	}

}
