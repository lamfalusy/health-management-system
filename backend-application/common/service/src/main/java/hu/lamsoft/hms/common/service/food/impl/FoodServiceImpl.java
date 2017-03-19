package hu.lamsoft.hms.common.service.food.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.lamsoft.hms.common.persistence.food.dao.FoodDao;
import hu.lamsoft.hms.common.service.food.FoodService;
import hu.lamsoft.hms.common.service.food.vo.FoodSearchVO;
import hu.lamsoft.hms.common.service.food.vo.FoodVO;
import hu.lamsoft.hms.common.service.food.vo.RecipeSearchVO;
import hu.lamsoft.hms.common.service.food.vo.RecipeVO;
import hu.lamsoft.hms.common.service.mapper.ModelMapper;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodDao foodDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<FoodVO> searchFood(FoodSearchVO foodSearchVO) {
		return modelMapper.convertToVO(foodDao.findAll(), FoodVO.class);
	}

	@Override
	public List<RecipeVO> searchRecipe(RecipeSearchVO recipeSearchVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
