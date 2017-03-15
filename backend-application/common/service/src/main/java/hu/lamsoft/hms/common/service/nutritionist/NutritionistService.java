package hu.lamsoft.hms.common.service.nutritionist;

import java.util.List;

import hu.lamsoft.hms.common.persistence.nutritionist.entity.BlogEntry;
import hu.lamsoft.hms.common.persistence.nutritionist.entity.Nutritionist;
import hu.lamsoft.hms.common.service.nutritionist.vo.BlogEntrySearchVO;
import hu.lamsoft.hms.common.service.nutritionist.vo.NutritionistSearchVO;

public interface NutritionistService {

	Nutritionist registrate(Nutritionist nutritionist);
	
	List<Nutritionist> searchNutritionist(NutritionistSearchVO nutritionistSearchVO);
	
	List<BlogEntry> searchBlogEntry(BlogEntrySearchVO blogEntrySearchVO);
	
}
