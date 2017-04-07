package hu.lamsoft.hms.common.service.nutritionist;

import org.springframework.data.domain.Page;

import hu.lamsoft.hms.common.service.nutritionist.vo.BlogEntrySearchVO;
import hu.lamsoft.hms.common.service.nutritionist.vo.BlogEntryVO;
import hu.lamsoft.hms.common.service.nutritionist.vo.NutritionistSearchVO;
import hu.lamsoft.hms.common.service.nutritionist.vo.NutritionistVO;

public interface NutritionistService {

	NutritionistVO registrate(NutritionistVO nutritionist);
	
	Page<NutritionistVO> searchNutritionist(NutritionistSearchVO nutritionistSearchVO);
	
	Page<BlogEntryVO> searchBlogEntry(BlogEntrySearchVO blogEntrySearchVO);
	
}
