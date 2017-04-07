package hu.lamsoft.hms.common.persistence.customer.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import hu.lamsoft.hms.common.persistence.customer.entity.CustomerHistoricalDataValue;
import hu.lamsoft.hms.common.persistence.dao.BaseDao;

@Repository
public interface CustomerHistoricalDataValueDao extends BaseDao<CustomerHistoricalDataValue> {

	List<CustomerHistoricalDataValue> findByCustomerEmailAndCustomerHistoricalDataCodeAndValidAtBetween(String customerEmail, String customerHistoricalDataCode, Date validAtFrom, Date validAtTo);
	
}
