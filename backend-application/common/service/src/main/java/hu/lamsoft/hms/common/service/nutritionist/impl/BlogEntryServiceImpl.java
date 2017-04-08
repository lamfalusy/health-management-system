package hu.lamsoft.hms.common.service.nutritionist.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import hu.lamsoft.hms.common.persistence.nutritionist.dao.BlogEntryDao;
import hu.lamsoft.hms.common.service.mapper.ModelMapper;
import hu.lamsoft.hms.common.service.nutritionist.BlogEntryService;
import hu.lamsoft.hms.common.service.nutritionist.vo.BlogEntrySearchVO;
import hu.lamsoft.hms.common.service.nutritionist.vo.BlogEntryVO;
import hu.lamsoft.hms.common.service.search.impl.SearchPredicateBuilderComponent;

@Service
@Transactional
public class BlogEntryServiceImpl implements BlogEntryService {

	@Autowired
	private BlogEntryDao blogEntryDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private SearchPredicateBuilderComponent searchPredicateBuilderComponent;
	
	@Override
	public Page<BlogEntryVO> searchBlogEntry(BlogEntrySearchVO blogEntrySearchVO) {
		return modelMapper.convertToVO(blogEntryDao.findAll(searchPredicateBuilderComponent.build(blogEntrySearchVO, BlogEntrySearchVO.class), blogEntrySearchVO), BlogEntryVO.class);
	}

}
