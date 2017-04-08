package hu.lamsoft.hms.nutritionist.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.hms.nutritionist.service.nutritionist.BlogEntryService;
import hu.lamsoft.hms.nutritionist.service.nutritionist.dto.BlogEntryDTO;
import hu.lamsoft.hms.nutritionist.service.nutritionist.vo.BlogEntrySearchVO;

@RestController
public class BlogEntryController {

	@Autowired
	private BlogEntryService blogEntryService;
	
	@RequestMapping(value = "/blog-entries", method = RequestMethod.GET)
    public Page<BlogEntryDTO> getBlogEntries(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
    		@RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        return blogEntryService.searchBlogEntry(new BlogEntrySearchVO(page, size));
    }
	
	@RequestMapping(value = "/blog-entries", method = RequestMethod.POST)
    public Page<BlogEntryDTO> getBlogEntries(@RequestBody BlogEntrySearchVO blogEntrySearchVO) {
        return blogEntryService.searchBlogEntry(blogEntrySearchVO);
    }
	
}
