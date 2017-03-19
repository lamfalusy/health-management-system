package hu.lamsoft.hms.common.service.regimen.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import hu.lamsoft.hms.common.service.customer.vo.CustomerVO;
import hu.lamsoft.hms.common.service.regimen.RegimenService;
import hu.lamsoft.hms.common.service.regimen.vo.RegimenForCustomerVO;
import hu.lamsoft.hms.common.service.regimen.vo.RegimenSearchVO;
import hu.lamsoft.hms.common.service.regimen.vo.RegimenVO;

@Service
@Transactional
public class RegimenServiceImpl implements RegimenService {

	@Override
	public List<RegimenVO> searchRegimen(RegimenSearchVO regimenSearchVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegimenForCustomerVO assignRegimenToCustomer(RegimenVO regimen, CustomerVO customer) {
		// TODO Auto-generated method stub
		return null;
	}

}
