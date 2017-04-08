package hu.lamsoft.hms.common.service.regimen;

import org.springframework.data.domain.Page;

import hu.lamsoft.hms.common.service.regimen.vo.RegimenSearchVO;
import hu.lamsoft.hms.common.service.regimen.vo.RegimenVO;

public interface RegimenService {

	Page<RegimenVO> searchRegimen(RegimenSearchVO regimenSearchVO);
	
}
