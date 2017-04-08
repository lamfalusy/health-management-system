package hu.lamsoft.hms.regimen.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.hms.common.restapi.security.jwt.AuthenticatedUser;
import hu.lamsoft.hms.common.service.customer.CustomerService;
import hu.lamsoft.hms.common.service.regimen.RegimenForCustomerService;
import hu.lamsoft.hms.common.service.regimen.dto.RegimenDTO;
import hu.lamsoft.hms.common.service.regimen.dto.RegimenForCustomerDTO;

@RestController
@RequestMapping("/secured")
public class RegimenForCustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RegimenForCustomerService regimenForCustomerService;
	
	@RequestMapping(value = "/assign-regimen", method = RequestMethod.POST)
    public RegimenForCustomerDTO getFoods(@RequestBody RegimenDTO regimen) {
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication();
        return regimenForCustomerService.assignRegimenToCustomer(regimen, customerService.getCustomer(authenticatedUser.getName()));
    }
	
	@RequestMapping(value = "/un-assign-regimen", method = RequestMethod.PUT)
    public RegimenForCustomerDTO getFoods(@RequestBody RegimenForCustomerDTO regimenForCustomer) {
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication();
        return regimenForCustomerService.unAssignRegimenToCustomer(regimenForCustomer, customerService.getCustomer(authenticatedUser.getName()));
    }
	
	@RequestMapping(value = "/regimens-for-customer", method = RequestMethod.GET)
    public List<RegimenForCustomerDTO> getRegimensForCustomer() {
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication();
        return regimenForCustomerService.getRegimenForCustomer(authenticatedUser.getName());
    }
	
}
