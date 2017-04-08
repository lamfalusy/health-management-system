package hu.lamsoft.hms.regimen.service.regimen;

import java.util.List;

import hu.lamsoft.hms.common.service.customer.dto.CustomerDTO;
import hu.lamsoft.hms.regimen.service.regimen.dto.RegimenDTO;
import hu.lamsoft.hms.regimen.service.regimen.dto.RegimenForCustomerDTO;

public interface RegimenForCustomerService {

	RegimenForCustomerDTO assignRegimenToCustomer(RegimenDTO regimen, CustomerDTO customer);
	
	RegimenForCustomerDTO unAssignRegimenToCustomer(RegimenForCustomerDTO regimenForCustomer, CustomerDTO customer);
	
	List<RegimenForCustomerDTO> getRegimenForCustomer(String email);
	
}
