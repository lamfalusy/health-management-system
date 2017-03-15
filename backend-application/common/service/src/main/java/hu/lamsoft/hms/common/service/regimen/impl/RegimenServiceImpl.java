package hu.lamsoft.hms.common.service.regimen.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import hu.lamsoft.hms.common.persistence.customer.entity.Customer;
import hu.lamsoft.hms.common.persistence.regimen.entity.Regimen;
import hu.lamsoft.hms.common.persistence.regimen.entity.RegimenForCustomer;
import hu.lamsoft.hms.common.service.regimen.RegimenService;
import hu.lamsoft.hms.common.service.regimen.vo.RegimenSearchVO;

@Service
@Transactional
public class RegimenServiceImpl implements RegimenService {

	@Override
	public List<Regimen> searchRegimen(RegimenSearchVO regimenSearchVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegimenForCustomer assignRegimenToCustomer(Regimen regimen, Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

}
