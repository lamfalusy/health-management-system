package hu.lamsoft.hms.common.service.nutritionist;

import org.springframework.data.domain.Page;

import hu.lamsoft.hms.common.service.nutritionist.dto.BlogEntryDTO;
import hu.lamsoft.hms.common.service.nutritionist.vo.BlogEntrySearchVO;

public interface BlogEntryService {

	Page<BlogEntryDTO> searchBlogEntry(BlogEntrySearchVO blogEntrySearchVO);
	
}
