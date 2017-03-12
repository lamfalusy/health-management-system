package hu.lamsoft.hms.service.regimen;

import java.util.List;

import hu.lamsoft.hms.model.customer.Customer;
import hu.lamsoft.hms.model.regimen.Regimen;
import hu.lamsoft.hms.model.regimen.RegimenForCustomer;
import hu.lamsoft.hms.service.regimen.vo.RegimenSearchVO;

public interface RegimenService {

	List<Regimen> searchRegimen(RegimenSearchVO regimenSearchVO);
	
	RegimenForCustomer assignRegimenToCustomer(Regimen regimen, Customer customer);
	
}
