package hu.lamsoft.hms.common.service.nutritionist;

import org.springframework.data.domain.Page;

import hu.lamsoft.hms.common.service.nutritionist.vo.BlogEntrySearchVO;
import hu.lamsoft.hms.common.service.nutritionist.vo.BlogEntryVO;

public interface BlogEntryService {

	Page<BlogEntryVO> searchBlogEntry(BlogEntrySearchVO blogEntrySearchVO);
	
}
