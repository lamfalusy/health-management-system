package hu.lamsoft.hms.common.service.customer.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import hu.lamsoft.hms.common.persistence.customer.dao.CustomerHistoricalDataDao;
import hu.lamsoft.hms.common.persistence.customer.dao.CustomerHistoricalDataValueDao;
import hu.lamsoft.hms.common.persistence.customer.entity.CustomerHistoricalData;
import hu.lamsoft.hms.common.persistence.customer.entity.CustomerHistoricalDataValue;
import hu.lamsoft.hms.common.service.customer.CustomerHistoricalDataService;
import hu.lamsoft.hms.common.service.customer.vo.CustomerHistoricalDataVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerHistoricalDataValueVO;
import hu.lamsoft.hms.common.service.mapper.ModelMapper;

@Service
@Transactional
public class CustomerHistoricalDataServiceImpl implements CustomerHistoricalDataService {

	@Autowired
	private CustomerHistoricalDataDao customerHistoricalDataDao;
	
	@Autowired
	private CustomerHistoricalDataValueDao customerHistoricalDataValueDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<CustomerHistoricalDataVO> getHistoricalDatas() {
		return modelMapper.convertToVO(customerHistoricalDataDao.findAll(), CustomerHistoricalDataVO.class);
	}
	
	@Override
	public CustomerHistoricalDataValueVO recordHistoricalData(CustomerHistoricalDataValueVO historicalDataValue) {
		Assert.notNull(historicalDataValue);
		Assert.isNull(historicalDataValue.getId());
		Assert.notNull(historicalDataValue.getCustomerHistoricalData());
		CustomerHistoricalData customerHistoricalData = customerHistoricalDataDao.findOne(historicalDataValue.getCustomerHistoricalData().getId());
		Assert.notNull(customerHistoricalData);
		CustomerHistoricalDataValue entity = modelMapper.convertToEntity(historicalDataValue, CustomerHistoricalDataValue.class);
		entity.setCustomerHistoricalData(customerHistoricalData);
		return modelMapper.convertToVO(customerHistoricalDataValueDao.save(entity), CustomerHistoricalDataValueVO.class);
	}

	@Override
	public List<CustomerHistoricalDataValueVO> getHistoricalData(String email, String historicalDataCode, Date fromDate, Date toDate) {
		return modelMapper.convertToVO(customerHistoricalDataValueDao.findByCustomerEmailAndCustomerHistoricalDataCodeAndValidAtBetween(email, historicalDataCode, fromDate, toDate), CustomerHistoricalDataValueVO.class);
	}

}
