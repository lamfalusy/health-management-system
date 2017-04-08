package hu.lamsoft.hms.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.hms.common.service.unit.UnitService;
import hu.lamsoft.hms.common.service.unit.vo.UnitVO;

@RestController
@RequestMapping("/secured")
public class UnitController {

	@Autowired
	private UnitService unitService;
	
	@RequestMapping(value = "/units", method = RequestMethod.GET)
    public List<UnitVO> getUnits() {
        return unitService.getUnits();
    }
	
}
