package hu.lamsoft.hms.common.service.customer;

import java.util.Date;
import java.util.List;

import hu.lamsoft.hms.common.service.customer.vo.CustomerHistoricalDataVO;
import hu.lamsoft.hms.common.service.customer.vo.CustomerHistoricalDataValueVO;

public interface CustomerHistoricalDataService {

	List<CustomerHistoricalDataVO> getHistoricalDatas();
	
	CustomerHistoricalDataValueVO recordHistoricalData(CustomerHistoricalDataValueVO historicalDataValue);
	
	List<CustomerHistoricalDataValueVO> getHistoricalData(String email, String historicalDataCode, Date fromDate, Date toDate);
	
}
