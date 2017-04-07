package hu.lamsoft.hms.common.service.food.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import hu.lamsoft.hms.common.persistence.food.dao.FoodDao;
import hu.lamsoft.hms.common.persistence.recipe.dao.RecipeDao;
import hu.lamsoft.hms.common.service.food.FoodService;
import hu.lamsoft.hms.common.service.food.vo.FoodSearchVO;
import hu.lamsoft.hms.common.service.food.vo.FoodVO;
import hu.lamsoft.hms.common.service.food.vo.RecipeSearchVO;
import hu.lamsoft.hms.common.service.food.vo.RecipeVO;
import hu.lamsoft.hms.common.service.mapper.ModelMapper;
import hu.lamsoft.hms.common.service.search.impl.SearchPredicateBuilderComponent;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodDao foodDao;
	
	@Autowired
	private RecipeDao recipeDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private SearchPredicateBuilderComponent searchPredicateBuilderComponent;
	
	@Override
	public Page<FoodVO> searchFood(FoodSearchVO foodSearchVO) {
		return modelMapper.convertToVO(foodDao.findAll(searchPredicateBuilderComponent.build(foodSearchVO, FoodSearchVO.class), foodSearchVO), FoodVO.class);
	}

	@Override
	public Page<RecipeVO> searchRecipe(RecipeSearchVO recipeSearchVO) {
		return modelMapper.convertToVO(recipeDao.findAll(searchPredicateBuilderComponent.build(recipeSearchVO, RecipeSearchVO.class), recipeSearchVO), RecipeVO.class);
	}

}
