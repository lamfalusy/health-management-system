package hu.lamsoft.hms.nutritionist.service.nutritionist.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import hu.lamsoft.hms.common.service.mapper.ModelMapper;
import hu.lamsoft.hms.common.service.search.impl.SearchPredicateBuilderContext;
import hu.lamsoft.hms.nutritionist.persistence.nutritionist.dao.BlogEntryDao;
import hu.lamsoft.hms.nutritionist.service.nutritionist.BlogEntryService;
import hu.lamsoft.hms.nutritionist.service.nutritionist.dto.BlogEntryDTO;
import hu.lamsoft.hms.nutritionist.service.nutritionist.vo.BlogEntrySearchVO;

@Service
@Transactional
public class BlogEntryServiceImpl implements BlogEntryService {

	@Autowired
	private BlogEntryDao blogEntryDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private SearchPredicateBuilderContext searchPredicateBuilderComponent;
	
	@Override
	public Page<BlogEntryDTO> searchBlogEntry(BlogEntrySearchVO blogEntrySearchVO) {
		return modelMapper.convertToDTO(blogEntryDao.findAll(searchPredicateBuilderComponent.build(blogEntrySearchVO, BlogEntrySearchVO.class), blogEntrySearchVO), BlogEntryDTO.class);
	}

}
