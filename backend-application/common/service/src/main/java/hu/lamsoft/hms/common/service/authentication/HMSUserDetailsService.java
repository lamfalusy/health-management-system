package hu.lamsoft.hms.common.service.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import hu.lamsoft.hms.common.persistence.customer.dao.CustomerDao;
import hu.lamsoft.hms.common.persistence.customer.entity.Customer;
import hu.lamsoft.hms.common.persistence.nutritionist.dao.NutritionistDao;

@Component
public class HMSUserDetailsService implements UserDetailsService {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private NutritionistDao nutritionistDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = customerDao.findByEmail(username);
		if(customer == null) {
			throw new UsernameNotFoundException("Email address not found.");
		}
		return new User(customer.getEmail(), customer.getPassword(), true, true, true, true, getGrantedAuthorities(customer));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(Customer customer){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(2);
        authorities.add(new SimpleGrantedAuthority("CUSTOMER"));
        if(nutritionistDao.findByCustomer(customer) != null) {
        	authorities.add(new SimpleGrantedAuthority("NUTRITIONIST"));
        }
        return authorities;
    }

}
