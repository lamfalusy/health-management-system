package hu.lamsoft.hms.common.restapi.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hu.lamsoft.hms.common.service.customer.dto.CustomerDTO;

@Service
public class CustomerRestService {

	private static final String CUSTOMER_SERVICE_URL = "http://CUSTOMER-APPLICATION";
	
	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;
	
	public CustomerDTO getCustomer(String email) {
		return restTemplate.getForObject(CUSTOMER_SERVICE_URL + "/internal/customer?email="+email, CustomerDTO.class);
	}
	
}
