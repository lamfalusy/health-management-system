package hu.lamsoft.hms.common.service.unit.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.lamsoft.hms.common.persistence.unit.dao.UnitDao;
import hu.lamsoft.hms.common.service.mapper.ModelMapper;
import hu.lamsoft.hms.common.service.unit.UnitService;
import hu.lamsoft.hms.common.service.unit.dto.UnitDTO;

@Service
@Transactional
public class UnitServiceImpl implements UnitService {

	@Autowired
	private UnitDao unitDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<UnitDTO> getUnits() {
		return modelMapper.convertToDTO(unitDao.findAll(), UnitDTO.class);
	}

}
