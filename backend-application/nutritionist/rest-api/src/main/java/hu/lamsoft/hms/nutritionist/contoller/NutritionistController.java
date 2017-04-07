package hu.lamsoft.hms.nutritionist.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.hms.common.restapi.security.jwt.AuthenticatedUser;
import hu.lamsoft.hms.common.service.customer.CustomerService;
import hu.lamsoft.hms.common.service.nutritionist.NutritionistService;
import hu.lamsoft.hms.common.service.nutritionist.vo.BlogEntrySearchVO;
import hu.lamsoft.hms.common.service.nutritionist.vo.BlogEntryVO;
import hu.lamsoft.hms.common.service.nutritionist.vo.NutritionistSearchVO;
import hu.lamsoft.hms.common.service.nutritionist.vo.NutritionistVO;

@RestController
public class NutritionistController {

	@Autowired
	private NutritionistService nutritionistService;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/nutritionists", method = RequestMethod.GET)
    public Page<NutritionistVO> getNutritionists(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
    		@RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        return nutritionistService.searchNutritionist(new NutritionistSearchVO(page, size));
    }
	
	@RequestMapping(value = "/nutritionists", method = RequestMethod.POST)
    public Page<NutritionistVO> getNutritionists(@RequestBody NutritionistSearchVO nutritionistSearchVO) {
        return nutritionistService.searchNutritionist(nutritionistSearchVO);
    }
	
	@RequestMapping(value = "/blog-entries", method = RequestMethod.GET)
    public Page<BlogEntryVO> getBlogEntries(@RequestParam(name = "page", required = false, defaultValue = "0") int page,
    		@RequestParam(name = "size", required = false, defaultValue = "10") int size) {
        return nutritionistService.searchBlogEntry(new BlogEntrySearchVO(page, size));
    }
	
	@RequestMapping(value = "/blog-entries", method = RequestMethod.POST)
    public Page<BlogEntryVO> getBlogEntries(@RequestBody BlogEntrySearchVO blogEntrySearchVO) {
        return nutritionistService.searchBlogEntry(blogEntrySearchVO);
    }
	
	@RequestMapping(value = "/nutritionist", method = RequestMethod.POST)
    public NutritionistVO postNutritionist(@RequestBody NutritionistVO nutritionistVO) {
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) SecurityContextHolder.getContext().getAuthentication();
		nutritionistVO.setCustomer(customerService.getCustomer(authenticatedUser.getName()));
		return nutritionistService.registrate(nutritionistVO);
    }
	
}
