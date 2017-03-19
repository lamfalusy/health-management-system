package hu.lamsoft.hms.common.service.nutritionist;

import java.util.List;

import hu.lamsoft.hms.common.service.nutritionist.vo.BlogEntrySearchVO;
import hu.lamsoft.hms.common.service.nutritionist.vo.BlogEntryVO;
import hu.lamsoft.hms.common.service.nutritionist.vo.NutritionistSearchVO;
import hu.lamsoft.hms.common.service.nutritionist.vo.NutritionistVO;

public interface NutritionistService {

	NutritionistVO registrate(NutritionistVO nutritionist);
	
	List<NutritionistVO> searchNutritionist(NutritionistSearchVO nutritionistSearchVO);
	
	List<BlogEntryVO> searchBlogEntry(BlogEntrySearchVO blogEntrySearchVO);
	
}
