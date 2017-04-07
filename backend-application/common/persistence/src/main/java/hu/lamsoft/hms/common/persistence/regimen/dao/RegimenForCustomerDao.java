package hu.lamsoft.hms.common.persistence.regimen.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import hu.lamsoft.hms.common.persistence.dao.BaseDao;
import hu.lamsoft.hms.common.persistence.regimen.entity.RegimenForCustomer;

@Repository
public interface RegimenForCustomerDao extends BaseDao<RegimenForCustomer> {

	List<RegimenForCustomer> findByCustomerEmail(String email);
	
}
