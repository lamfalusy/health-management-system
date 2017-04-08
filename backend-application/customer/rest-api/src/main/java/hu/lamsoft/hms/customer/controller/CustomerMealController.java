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
import hu.lamsoft.hms.common.service.customer.CustomerMealService;
import hu.lamsoft.hms.common.service.customer.CustomerService;
import hu.lamsoft.hms.common.service.customer.dto.CustomerMealDTO;

@RestController
@RequestMapping("/secured")
public class CustomerMealController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerMealService customerMealService;
	
	@RequestMapping(value = "/meals", method = RequestMethod.GET)
    public List<Meal> getMeals() {
        return customerMealService.getMeals();
    }
	
	@RequestMapping(value = "/customer-meal", method = RequestMethod.POST)
    public CustomerMealDTO postCustomerMeal(@RequestBody CustomerMealDTO customerMeal) {
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication();
		customerMeal.setCustomer(customerService.getCustomer(authenticatedUser.getName()));
        return customerMealService.recordCustomerMeal(customerMeal);
    }
	
	@RequestMapping(value = "/customer-meals", method = RequestMethod.GET)
    public List<CustomerMealDTO> getCustomerMeals(
    		@RequestParam(name = "fromDate", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate,
    		@RequestParam(name = "toDate", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date toDate) {
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication();
        return customerMealService.getCustomerMeal(authenticatedUser.getName(), fromDate, toDate);
    }
	
}
