package hu.lamsoft.hms.regimen.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.hms.common.restapi.security.jwt.AuthenticatedUser;
import hu.lamsoft.hms.common.service.customer.CustomerService;
import hu.lamsoft.hms.common.service.regimen.RegimenService;
import hu.lamsoft.hms.common.service.regimen.vo.RegimenForCustomerVO;
import hu.lamsoft.hms.common.service.regimen.vo.RegimenSearchVO;
import hu.lamsoft.hms.common.service.regimen.vo.RegimenVO;

@RestController
public class RegimenController {

	@Autowired
	private RegimenService regimenService;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/regimens", method = RequestMethod.GET)
    public Page<RegimenVO> getFoods(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
    		@RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        return regimenService.searchRegimen(new RegimenSearchVO(page, size));
    }
	
	@RequestMapping(value = "/regimens", method = RequestMethod.POST)
    public Page<RegimenVO> getFoods(@RequestBody RegimenSearchVO foodSearchVO) {
        return regimenService.searchRegimen(foodSearchVO);
    }
	
	@RequestMapping(value = "/secured/assign-regimen", method = RequestMethod.POST)
    public RegimenForCustomerVO getFoods(@RequestBody RegimenVO regimenVO) {
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication();
        return regimenService.assignRegimenToCustomer(regimenVO, customerService.getCustomer(authenticatedUser.getName()));
    }
	
	@RequestMapping(value = "/secured/un-assign-regimen", method = RequestMethod.PUT)
    public RegimenForCustomerVO getFoods(@RequestBody RegimenForCustomerVO regimenForCustomerVO) {
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication();
        return regimenService.unAssignRegimenToCustomer(regimenForCustomerVO, customerService.getCustomer(authenticatedUser.getName()));
    }
	
	@RequestMapping(value = "/secured/regimens-for-customer", method = RequestMethod.GET)
    public List<RegimenForCustomerVO> getRegimensForCustomer() {
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication();
        return regimenService.getRegimenForCustomer(authenticatedUser.getName());
    }
	
}
