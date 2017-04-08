package hu.lamsoft.hms.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.hms.common.service.customer.CustomerService;
import hu.lamsoft.hms.common.service.customer.vo.CustomerRegistrationVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerVO;

@RestController
public class RegistrateController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/registrate", method = RequestMethod.POST)
    public CustomerVO registrate(@RequestBody CustomerRegistrationVO customer) {
        return customerService.registrate(customer);
    }
	
}
