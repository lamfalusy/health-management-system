package hu.lamsoft.hms.customer.persistence.customer.dao;

import org.springframework.stereotype.Repository;

import hu.lamsoft.hms.common.persistence.dao.BaseDao;
import hu.lamsoft.hms.customer.persistence.customer.entity.CustomerHistoricalData;

@Repository
public interface CustomerHistoricalDataDao extends BaseDao<CustomerHistoricalData> {

}
