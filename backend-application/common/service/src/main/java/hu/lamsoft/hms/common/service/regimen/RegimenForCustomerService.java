package hu.lamsoft.hms.common.service.regimen;

import java.util.List;

import hu.lamsoft.hms.common.service.customer.vo.CustomerVO;
import hu.lamsoft.hms.common.service.regimen.vo.RegimenForCustomerVO;
import hu.lamsoft.hms.common.service.regimen.vo.RegimenVO;

public interface RegimenForCustomerService {

	RegimenForCustomerVO assignRegimenToCustomer(RegimenVO regimen, CustomerVO customer);
	
	RegimenForCustomerVO unAssignRegimenToCustomer(RegimenForCustomerVO regimenForCustomer, CustomerVO customer);
	
	List<RegimenForCustomerVO> getRegimenForCustomer(String email);
	
}
