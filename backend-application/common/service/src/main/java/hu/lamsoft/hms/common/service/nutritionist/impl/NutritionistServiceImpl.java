package hu.lamsoft.hms.common.service.nutritionist.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import hu.lamsoft.hms.common.service.nutritionist.NutritionistService;
import hu.lamsoft.hms.common.service.nutritionist.vo.BlogEntrySearchVO;
import hu.lamsoft.hms.common.service.nutritionist.vo.BlogEntryVO;
import hu.lamsoft.hms.common.service.nutritionist.vo.NutritionistSearchVO;
import hu.lamsoft.hms.common.service.nutritionist.vo.NutritionistVO;

@Service
@Transactional
public class NutritionistServiceImpl implements NutritionistService {

	@Override
	public NutritionistVO registrate(NutritionistVO nutritionist) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NutritionistVO> searchNutritionist(NutritionistSearchVO nutritionistSearchVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogEntryVO> searchBlogEntry(BlogEntrySearchVO blogEntrySearchVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
