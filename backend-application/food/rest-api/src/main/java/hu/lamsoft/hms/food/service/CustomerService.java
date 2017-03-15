package hu.lamsoft.hms.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

	private static final String SERVICE_URL = "http://CUSTOMER-APPLICATION";
	
	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;
	
	public String hello() {
		return restTemplate.getForObject(SERVICE_URL, String.class);
	}
	
}
