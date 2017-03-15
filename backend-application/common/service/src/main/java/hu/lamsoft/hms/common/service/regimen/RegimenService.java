package hu.lamsoft.hms.common.service.regimen;

import java.util.List;

import hu.lamsoft.hms.common.persistence.customer.entity.Customer;
import hu.lamsoft.hms.common.persistence.regimen.entity.Regimen;
import hu.lamsoft.hms.common.persistence.regimen.entity.RegimenForCustomer;
import hu.lamsoft.hms.common.service.regimen.vo.RegimenSearchVO;

public interface RegimenService {

	List<Regimen> searchRegimen(RegimenSearchVO regimenSearchVO);
	
	RegimenForCustomer assignRegimenToCustomer(Regimen regimen, Customer customer);
	
}
