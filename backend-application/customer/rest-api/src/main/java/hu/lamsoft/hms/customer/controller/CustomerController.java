package hu.lamsoft.hms.customer.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.hms.common.persistence.regimen.enums.Meal;
import hu.lamsoft.hms.common.restapi.security.jwt.AuthenticatedUser;
import hu.lamsoft.hms.common.service.customer.CustomerService;
import hu.lamsoft.hms.common.service.customer.vo.CustomerHistoricalDataVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerHistoricalDataValueVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerMealVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerVO;
import hu.lamsoft.hms.common.service.unit.vo.UnitVO;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/secured/customer", method = RequestMethod.GET)
    public CustomerVO getCustomerProfile() {
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication();
        return customerService.getCustomer(authenticatedUser.getName());
    }
	
	@RequestMapping(value = "/secured/historical-data-value", method = RequestMethod.POST)
    public CustomerHistoricalDataValueVO postHistoricalDataValue(@RequestBody CustomerHistoricalDataValueVO historicalDataValue) {
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication();
		historicalDataValue.setCustomer(customerService.getCustomer(authenticatedUser.getName()));
        return customerService.recordHistoricalData(historicalDataValue);
    }

	@RequestMapping(value = "/secured/historical-datas", method = RequestMethod.GET)
    public List<CustomerHistoricalDataVO> getCustomerHistoricalDatas() {
        return customerService.getHistoricalDatas();
    }
	
	@RequestMapping(value = "/secured/historical-data-values", method = RequestMethod.GET)
    public List<CustomerHistoricalDataValueVO> getHistoricalDataValues(
    		@RequestParam(name = "historicalDataCode", required = true) String historicalDataCode,
    		@RequestParam(name = "fromDate", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate,
    		@RequestParam(name = "toDate", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date toDate) {
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication();
        return customerService.getHistoricalData(authenticatedUser.getName(), historicalDataCode, fromDate, toDate);
    }
	
	@RequestMapping(value = "/secured/meals", method = RequestMethod.GET)
    public List<Meal> getMeals() {
        return customerService.getMeals();
    }
	
	@RequestMapping(value = "/secured/units", method = RequestMethod.GET)
    public List<UnitVO> getUnits() {
        return customerService.getUnits();
    }
	
	@RequestMapping(value = "/secured/customer-meal", method = RequestMethod.POST)
    public CustomerMealVO postCustomerMeal(@RequestBody CustomerMealVO customerMealVO) {
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication();
		customerMealVO.setCustomer(customerService.getCustomer(authenticatedUser.getName()));
        return customerService.recordCustomerMeal(customerMealVO);
    }
	
	@RequestMapping(value = "/secured/customer-meals", method = RequestMethod.GET)
    public List<CustomerMealVO> getCustomerMeals(
    		@RequestParam(name = "fromDate", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate,
    		@RequestParam(name = "toDate", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date toDate) {
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication();
        return customerService.getCustomerMeal(authenticatedUser.getName(), fromDate, toDate);
    }
	
}
