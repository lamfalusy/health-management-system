package hu.lamsoft.hms.nutritionist.service.nutritionist;

import org.springframework.data.domain.Page;

import hu.lamsoft.hms.nutritionist.service.nutritionist.dto.BlogEntryDTO;
import hu.lamsoft.hms.nutritionist.service.nutritionist.vo.BlogEntrySearchVO;

public interface BlogEntryService {

	Page<BlogEntryDTO> searchBlogEntry(BlogEntrySearchVO blogEntrySearchVO);
	
}
