package hu.lamsoft.hms.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.hms.common.service.customer.dto.CustomerDTO;
import hu.lamsoft.hms.customer.service.customer.CustomerService;

@RestController
@RequestMapping("/internal")
public class InternalController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
    public CustomerDTO getCustomerProfile(@RequestParam(name = "email", required = true) String email) {
        return customerService.getCustomer(email);
    }
	
}
