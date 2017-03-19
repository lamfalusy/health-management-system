package hu.lamsoft.hms.common.service.regimen;

import java.util.List;

import hu.lamsoft.hms.common.service.customer.vo.CustomerVO;
import hu.lamsoft.hms.common.service.regimen.vo.RegimenForCustomerVO;
import hu.lamsoft.hms.common.service.regimen.vo.RegimenSearchVO;
import hu.lamsoft.hms.common.service.regimen.vo.RegimenVO;

public interface RegimenService {

	List<RegimenVO> searchRegimen(RegimenSearchVO regimenSearchVO);
	
	RegimenForCustomerVO assignRegimenToCustomer(RegimenVO regimen, CustomerVO customer);
	
}
