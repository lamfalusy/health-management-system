package hu.lamsoft.hms.common.service.regimen.dto;

import java.util.Date;

import hu.lamsoft.hms.common.service.customer.dto.CustomerDTO;
import hu.lamsoft.hms.common.service.dto.BaseDTO;
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
