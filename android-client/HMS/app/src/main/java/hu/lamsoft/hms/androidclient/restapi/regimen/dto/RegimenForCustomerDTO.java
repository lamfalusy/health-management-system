package hu.lamsoft.hms.androidclient.restapi.regimen.dto;

import java.util.Date;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;
import hu.lamsoft.hms.androidclient.restapi.customer.dto.CustomerDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenForCustomerDTO extends BaseDTO {

	private CustomerDTO customer;
	private RegimenDTO regimen;
	private Date startDate;
	private Date endDate;
	
}
