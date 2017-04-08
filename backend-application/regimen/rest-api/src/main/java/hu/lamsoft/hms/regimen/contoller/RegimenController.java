package hu.lamsoft.hms.regimen.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.hms.regimen.service.regimen.RegimenService;
import hu.lamsoft.hms.regimen.service.regimen.dto.RegimenDTO;
import hu.lamsoft.hms.regimen.service.regimen.vo.RegimenSearchVO;

@RestController
public class RegimenController {

	@Autowired
	private RegimenService regimenService;
	
	@RequestMapping(value = "/regimens", method = RequestMethod.GET)
    public Page<RegimenDTO> getFoods(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
    		@RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        return regimenService.searchRegimen(new RegimenSearchVO(page, size));
    }
	
	@RequestMapping(value = "/regimens", method = RequestMethod.POST)
    public Page<RegimenDTO> getFoods(@RequestBody RegimenSearchVO foodSearchVO) {
        return regimenService.searchRegimen(foodSearchVO);
    }
	
}
