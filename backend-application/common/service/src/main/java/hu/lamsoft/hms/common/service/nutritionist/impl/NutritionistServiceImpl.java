package hu.lamsoft.hms.common.service.nutritionist.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import hu.lamsoft.hms.common.persistence.nutritionist.entity.BlogEntry;
import hu.lamsoft.hms.common.persistence.nutritionist.entity.Nutritionist;
import hu.lamsoft.hms.common.service.nutritionist.NutritionistService;
import hu.lamsoft.hms.common.service.nutritionist.vo.BlogEntrySearchVO;
import hu.lamsoft.hms.common.service.nutritionist.vo.NutritionistSearchVO;

@Service
@Transactional
public class NutritionistServiceImpl implements NutritionistService {

	@Override
	public Nutritionist registrate(Nutritionist nutritionist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Nutritionist> searchNutritionist(NutritionistSearchVO nutritionistSearchVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogEntry> searchBlogEntry(BlogEntrySearchVO blogEntrySearchVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
