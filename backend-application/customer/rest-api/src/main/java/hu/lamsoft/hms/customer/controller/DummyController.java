package hu.lamsoft.hms.customer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

	@RequestMapping
    public String greeting() {
        return "Customer application";
    }
	
}
