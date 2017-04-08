package hu.lamsoft.hms.customer.service.customer.dto;

import java.util.Date;

import hu.lamsoft.hms.common.service.customer.dto.CustomerDTO;
import hu.lamsoft.hms.common.service.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CustomerHistoricalDataValueDTO extends BaseDTO {

	private CustomerDTO customer;
	private CustomerHistoricalDataDTO customerHistoricalData;
	private Date validAt;
	private Long longValue;
	private String stringValue;
	private Double doubleValue;
	
}
