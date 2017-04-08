package hu.lamsoft.hms.common.service.customer;

import java.util.Date;
import java.util.List;

import hu.lamsoft.hms.common.service.customer.dto.CustomerHistoricalDataDTO;
import hu.lamsoft.hms.common.service.customer.dto.CustomerHistoricalDataValueDTO;

public interface CustomerHistoricalDataService {

	List<CustomerHistoricalDataDTO> getHistoricalDatas();
	
	CustomerHistoricalDataValueDTO recordHistoricalData(CustomerHistoricalDataValueDTO historicalDataValue);
	
	List<CustomerHistoricalDataValueDTO> getHistoricalData(String email, String historicalDataCode, Date fromDate, Date toDate);
	
}
