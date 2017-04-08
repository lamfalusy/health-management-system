package hu.lamsoft.hms.common.service.customer.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import hu.lamsoft.hms.common.persistence.customer.dao.CustomerMealDao;
import hu.lamsoft.hms.common.persistence.customer.entity.CustomerMeal;
import hu.lamsoft.hms.common.persistence.food.dao.FoodDao;
import hu.lamsoft.hms.common.persistence.food.entity.Food;
import hu.lamsoft.hms.common.persistence.regimen.enums.Meal;
import hu.lamsoft.hms.common.persistence.unit.dao.UnitDao;
import hu.lamsoft.hms.common.persistence.unit.entity.Unit;
import hu.lamsoft.hms.common.service.customer.CustomerMealService;
import hu.lamsoft.hms.common.service.customer.dto.CustomerMealDTO;
import hu.lamsoft.hms.common.service.mapper.ModelMapper;

@Service
@Transactional
public class CustomerMealServiceImpl implements CustomerMealService {
	
	@Autowired
	private CustomerMealDao customerMealDao;
	
	@Autowired
	private UnitDao unitDao;
	
	@Autowired
	private FoodDao foodDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<Meal> getMeals() {
		return Arrays.asList(Meal.values());
	}

	@Override
	public CustomerMealDTO recordCustomerMeal(CustomerMealDTO customerMeal) {
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
		return modelMapper.convertToDTO(customerMealDao.save(entity), CustomerMealDTO.class);
	}

	@Override
	public List<CustomerMealDTO> getCustomerMeal(String email, Date fromDate, Date toDate) {
		return modelMapper.convertToDTO(customerMealDao.findByCustomerEmailAndTimeOfMealBetween(email, fromDate, toDate), CustomerMealDTO.class);
	}

}
