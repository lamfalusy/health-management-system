package hu.lamsoft.hms.service.nutritionist;

import java.util.List;

import hu.lamsoft.hms.model.nutritionist.BlogEntry;
import hu.lamsoft.hms.model.nutritionist.Nutritionist;
import hu.lamsoft.hms.service.nutritionist.vo.BlogEntrySearchVO;
import hu.lamsoft.hms.service.nutritionist.vo.NutritionistSearchVO;

public interface NutritionistService {

	Nutritionist registrate(Nutritionist nutritionist);
	
	List<Nutritionist> searchNutritionist(NutritionistSearchVO nutritionistSearchVO);
	
	List<BlogEntry> searchBlogEntry(BlogEntrySearchVO blogEntrySearchVO);
	
}
