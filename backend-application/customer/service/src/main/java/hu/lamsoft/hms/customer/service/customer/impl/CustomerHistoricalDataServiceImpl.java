package hu.lamsoft.hms.customer.service.customer.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import hu.lamsoft.hms.common.service.mapper.ModelMapper;
import hu.lamsoft.hms.customer.persistence.customer.dao.CustomerHistoricalDataDao;
import hu.lamsoft.hms.customer.persistence.customer.dao.CustomerHistoricalDataValueDao;
import hu.lamsoft.hms.customer.persistence.customer.entity.CustomerHistoricalData;
import hu.lamsoft.hms.customer.persistence.customer.entity.CustomerHistoricalDataValue;
import hu.lamsoft.hms.customer.service.customer.CustomerHistoricalDataService;
import hu.lamsoft.hms.customer.service.customer.dto.CustomerHistoricalDataDTO;
import hu.lamsoft.hms.customer.service.customer.dto.CustomerHistoricalDataValueDTO;

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
	public List<CustomerHistoricalDataDTO> getHistoricalDatas() {
		return modelMapper.convertToDTO(customerHistoricalDataDao.findAll(), CustomerHistoricalDataDTO.class);
	}
	
	@Override
	public CustomerHistoricalDataValueDTO recordHistoricalData(CustomerHistoricalDataValueDTO historicalDataValue) {
		Assert.notNull(historicalDataValue);
		Assert.isNull(historicalDataValue.getId());
		Assert.notNull(historicalDataValue.getCustomerHistoricalData());
		CustomerHistoricalData customerHistoricalData = customerHistoricalDataDao.findOne(historicalDataValue.getCustomerHistoricalData().getId());
		Assert.notNull(customerHistoricalData);
		CustomerHistoricalDataValue entity = modelMapper.convertToEntity(historicalDataValue, CustomerHistoricalDataValue.class);
		entity.setCustomerHistoricalData(customerHistoricalData);
		return modelMapper.convertToDTO(customerHistoricalDataValueDao.save(entity), CustomerHistoricalDataValueDTO.class);
	}

	@Override
	public List<CustomerHistoricalDataValueDTO> getHistoricalData(String email, String historicalDataCode, Date fromDate, Date toDate) {
		return modelMapper.convertToDTO(customerHistoricalDataValueDao.findByCustomerEmailAndCustomerHistoricalDataCodeAndValidAtBetween(email, historicalDataCode, fromDate, toDate), CustomerHistoricalDataValueDTO.class);
	}

}
