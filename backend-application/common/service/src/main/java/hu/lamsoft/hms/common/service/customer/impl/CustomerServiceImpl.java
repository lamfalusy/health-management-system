package hu.lamsoft.hms.common.service.customer.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import hu.lamsoft.hms.common.persistence.customer.dao.CustomerDao;
import hu.lamsoft.hms.common.persistence.customer.dao.CustomerHistoricalDataDao;
import hu.lamsoft.hms.common.persistence.customer.dao.CustomerHistoricalDataValueDao;
import hu.lamsoft.hms.common.persistence.customer.dao.CustomerMealDao;
import hu.lamsoft.hms.common.persistence.customer.entity.Customer;
import hu.lamsoft.hms.common.persistence.customer.entity.CustomerHistoricalData;
import hu.lamsoft.hms.common.persistence.customer.entity.CustomerHistoricalDataValue;
import hu.lamsoft.hms.common.persistence.customer.entity.CustomerMeal;
import hu.lamsoft.hms.common.persistence.food.dao.FoodDao;
import hu.lamsoft.hms.common.persistence.food.entity.Food;
import hu.lamsoft.hms.common.persistence.regimen.enums.Meal;
import hu.lamsoft.hms.common.persistence.unit.dao.UnitDao;
import hu.lamsoft.hms.common.persistence.unit.entity.Unit;
import hu.lamsoft.hms.common.service.customer.CustomerService;
import hu.lamsoft.hms.common.service.customer.exception.EmailAddressAlreadyUsedException;
import hu.lamsoft.hms.common.service.customer.vo.CustomerHistoricalDataVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerHistoricalDataValueVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerMealVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerRegistrationVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerVO;
import hu.lamsoft.hms.common.service.mapper.ModelMapper;
import hu.lamsoft.hms.common.service.unit.vo.UnitVO;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private CustomerMealDao customerMealDao;
	
	@Autowired
	private CustomerHistoricalDataDao customerHistoricalDataDao;
	
	@Autowired
	private CustomerHistoricalDataValueDao customerHistoricalDataValueDao;
	
	@Autowired
	private UnitDao unitDao;
	
	@Autowired
	private FoodDao foodDao;
	
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
	public List<Meal> getMeals() {
		return Arrays.asList(Meal.values());
	}
	
	@Override
	public List<UnitVO> getUnits() {
		return modelMapper.convertToVO(unitDao.findAll(), UnitVO.class);
	}
	
	@Override
	public CustomerMealVO recordCustomerMeal(CustomerMealVO customerMeal) {
		Assert.notNull(customerMeal);
		Assert.isNull(customerMeal.getId());
		Assert.notNull(customerMeal.getFood());
		Assert.notNull(customerMeal.getFood().getId());
		Assert.notNull(customerMeal.getQuantity());
		Assert.isNull(customerMeal.getQuantity().getId());
		Assert.notNull(customerMeal.getQuantity().getUnit());
		Assert.notNull(customerMeal.getQuantity().getUnit().getId());
		Food food = foodDao.findOne(customerMeal.getFood().getId());
		Assert.notNull(food);
		Unit unit = unitDao.findOne(customerMeal.getQuantity().getUnit().getId());
		Assert.notNull(unit);
		CustomerMeal entity = modelMapper.convertToEntity(customerMeal, CustomerMeal.class);
		entity.setFood(food);
		entity.getQuantity().setUnit(unit);
		return modelMapper.convertToVO(customerMealDao.save(entity), CustomerMealVO.class);
	}

	@Override
	public List<CustomerHistoricalDataValueVO> getHistoricalData(String email, String historicalDataCode, Date fromDate, Date toDate) {
		return modelMapper.convertToVO(customerHistoricalDataValueDao.findByCustomerEmailAndCustomerHistoricalDataCodeAndValidAtBetween(email, historicalDataCode, fromDate, toDate), CustomerHistoricalDataValueVO.class);
	}

	@Override
	public List<CustomerMealVO> getCustomerMeal(String email, Date fromDate, Date toDate) {
		return modelMapper.convertToVO(customerMealDao.findByCustomerEmailAndTimeOfMealBetween(email, fromDate, toDate), CustomerMealVO.class);
	}

}
