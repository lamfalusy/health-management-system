package hu.lamsoft.hms.customer.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.hms.common.restapi.security.jwt.AuthenticatedUser;
import hu.lamsoft.hms.common.service.customer.CustomerHistoricalDataService;
import hu.lamsoft.hms.common.service.customer.CustomerService;
import hu.lamsoft.hms.common.service.customer.vo.CustomerHistoricalDataVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerHistoricalDataValueVO;

@RestController
@RequestMapping("/secured")
public class CustomerHistoricalDataController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerHistoricalDataService customerHistoricalDataService;
	
	@RequestMapping(value = "/historical-data-value", method = RequestMethod.POST)
    public CustomerHistoricalDataValueVO postHistoricalDataValue(@RequestBody CustomerHistoricalDataValueVO historicalDataValue) {
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication();
		historicalDataValue.setCustomer(customerService.getCustomer(authenticatedUser.getName()));
        return customerHistoricalDataService.recordHistoricalData(historicalDataValue);
    }

	@RequestMapping(value = "/historical-datas", method = RequestMethod.GET)
    public List<CustomerHistoricalDataVO> getCustomerHistoricalDatas() {
        return customerHistoricalDataService.getHistoricalDatas();
    }
	
	@RequestMapping(value = "/historical-data-values", method = RequestMethod.GET)
    public List<CustomerHistoricalDataValueVO> getHistoricalDataValues(
    		@RequestParam(name = "historicalDataCode", required = true) String historicalDataCode,
    		@RequestParam(name = "fromDate", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate,
    		@RequestParam(name = "toDate", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date toDate) {
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication();
        return customerHistoricalDataService.getHistoricalData(authenticatedUser.getName(), historicalDataCode, fromDate, toDate);
    }
	
}
