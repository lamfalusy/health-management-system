package hu.lamsoft.hms.common.service.food.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.lamsoft.hms.common.persistence.food.dao.FoodDao;
import hu.lamsoft.hms.common.persistence.food.entity.Food;
import hu.lamsoft.hms.common.persistence.recipe.entity.Recipe;
import hu.lamsoft.hms.common.service.food.FoodService;
import hu.lamsoft.hms.common.service.food.vo.FoodSearchVO;
import hu.lamsoft.hms.common.service.food.vo.RecipeSearchVO;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodDao foodDao;
	
	@Override
	public List<Food> searchFood(FoodSearchVO foodSearchVO) {
		return foodDao.findAll();
	}

	@Override
	public List<Recipe> searchRecipe(RecipeSearchVO recipeSearchVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
