package hu.lamsoft.hms.nutritionist.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.hms.common.service.nutritionist.BlogEntryService;
import hu.lamsoft.hms.common.service.nutritionist.vo.BlogEntrySearchVO;
import hu.lamsoft.hms.common.service.nutritionist.vo.BlogEntryVO;

@RestController
public class BlogEntryController {

	@Autowired
	private BlogEntryService blogEntryService;
	
	@RequestMapping(value = "/blog-entries", method = RequestMethod.GET)
    public Page<BlogEntryVO> getBlogEntries(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
    		@RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        return blogEntryService.searchBlogEntry(new BlogEntrySearchVO(page, size));
    }
	
	@RequestMapping(value = "/blog-entries", method = RequestMethod.POST)
    public Page<BlogEntryVO> getBlogEntries(@RequestBody BlogEntrySearchVO blogEntrySearchVO) {
        return blogEntryService.searchBlogEntry(blogEntrySearchVO);
    }
	
}
