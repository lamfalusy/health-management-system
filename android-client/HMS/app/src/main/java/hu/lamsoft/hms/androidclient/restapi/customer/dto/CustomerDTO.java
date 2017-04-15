package hu.lamsoft.hms.androidclient.restapi.customer.dto;

import java.util.Date;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CustomerDTO extends BaseDTO {

	private String email;
	private String firstname;
	private String lastname;
	private Date birthday;

}
