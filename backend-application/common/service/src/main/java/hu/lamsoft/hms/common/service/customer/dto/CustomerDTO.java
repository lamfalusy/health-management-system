package hu.lamsoft.hms.common.service.customer.dto;

import java.util.Date;

import hu.lamsoft.hms.common.service.dto.BaseDTO;
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
