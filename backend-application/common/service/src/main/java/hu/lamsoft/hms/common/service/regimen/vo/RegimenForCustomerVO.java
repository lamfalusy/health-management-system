package hu.lamsoft.hms.common.service.regimen.vo;

import java.util.Date;

import hu.lamsoft.hms.common.service.customer.vo.CustomerVO;
import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenForCustomerVO extends BaseVO {

	private CustomerVO customer;
	private RegimenVO regimen;
	private Date startDate;
	private Date endDate;
	
}
