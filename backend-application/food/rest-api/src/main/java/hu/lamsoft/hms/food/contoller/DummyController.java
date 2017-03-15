package hu.lamsoft.hms.food.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.hms.food.service.CustomerService;

@RestController
public class DummyController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping
    public String greeting() {
        return "Food application which called "+customerService.hello();
    }
	
}
