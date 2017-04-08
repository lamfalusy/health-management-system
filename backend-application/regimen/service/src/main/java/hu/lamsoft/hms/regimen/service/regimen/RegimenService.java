package hu.lamsoft.hms.regimen.service.regimen;

import org.springframework.data.domain.Page;

import hu.lamsoft.hms.regimen.service.regimen.dto.RegimenDTO;
import hu.lamsoft.hms.regimen.service.regimen.vo.RegimenSearchVO;

public interface RegimenService {

	Page<RegimenDTO> searchRegimen(RegimenSearchVO regimenSearchVO);
	
}
