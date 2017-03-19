package hu.lamsoft.hms.common.service.customer.vo;

import java.util.Date;

import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CustomerVO extends BaseVO {

	private String email;
	private String firstname;
	private String lastname;
	private Date birthday;

}
