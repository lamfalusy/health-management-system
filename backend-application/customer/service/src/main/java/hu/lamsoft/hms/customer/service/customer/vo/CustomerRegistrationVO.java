package hu.lamsoft.hms.customer.service.customer.vo;

import java.util.Date;

import lombok.Data;

@Data
public class CustomerRegistrationVO {

	private String email;
	private String firstname;
	private String lastname;
	private Date birthday;
	private String rawPassword;
	
}
