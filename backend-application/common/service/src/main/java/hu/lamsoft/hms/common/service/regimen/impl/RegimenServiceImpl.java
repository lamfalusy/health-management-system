package hu.lamsoft.hms.common.service.regimen.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import hu.lamsoft.hms.common.persistence.regimen.dao.RegimenDao;
import hu.lamsoft.hms.common.service.mapper.ModelMapper;
import hu.lamsoft.hms.common.service.regimen.RegimenService;
import hu.lamsoft.hms.common.service.regimen.dto.RegimenDTO;
import hu.lamsoft.hms.common.service.regimen.vo.RegimenSearchVO;
import hu.lamsoft.hms.common.service.search.impl.SearchPredicateBuilderComponent;

@Service
@Transactional
public class RegimenServiceImpl implements RegimenService {

	@Autowired
	private RegimenDao regimenDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private SearchPredicateBuilderComponent searchPredicateBuilderComponent;	
	
	@Override
	public Page<RegimenDTO> searchRegimen(RegimenSearchVO regimenSearchVO) {
		return modelMapper.convertToDTO(regimenDao.findAll(searchPredicateBuilderComponent.build(regimenSearchVO, RegimenSearchVO.class), regimenSearchVO), RegimenDTO.class);
	}

}
