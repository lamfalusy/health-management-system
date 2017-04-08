package hu.lamsoft.hms.common.service.regimen;

import org.springframework.data.domain.Page;

import hu.lamsoft.hms.common.service.regimen.dto.RegimenDTO;
import hu.lamsoft.hms.common.service.regimen.vo.RegimenSearchVO;

public interface RegimenService {

	Page<RegimenDTO> searchRegimen(RegimenSearchVO regimenSearchVO);
	
}
