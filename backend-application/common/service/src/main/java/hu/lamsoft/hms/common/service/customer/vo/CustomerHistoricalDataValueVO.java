package hu.lamsoft.hms.common.service.customer.vo;

import java.util.Date;

import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CustomerHistoricalDataValueVO extends BaseVO {

	private CustomerVO customer;
	private CustomerHistoricalDataVO customerHistoricalData;
	private Date validAt;
	private Long longValue;
	private String stringValue;
	private Double doubleValue;
	
}
