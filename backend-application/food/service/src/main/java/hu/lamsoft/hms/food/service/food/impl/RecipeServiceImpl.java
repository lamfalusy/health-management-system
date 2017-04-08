package hu.lamsoft.hms.food.service.food.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import hu.lamsoft.hms.common.service.food.dto.RecipeDTO;
import hu.lamsoft.hms.common.service.mapper.ModelMapper;
import hu.lamsoft.hms.common.service.search.impl.SearchPredicateBuilderContext;
import hu.lamsoft.hms.food.persistence.food.dao.RecipeDao;
import hu.lamsoft.hms.food.service.food.RecipeService;
import hu.lamsoft.hms.food.service.food.vo.RecipeSearchVO;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeDao recipeDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private SearchPredicateBuilderContext searchPredicateBuilderComponent;
	
	@Override
	public Page<RecipeDTO> searchRecipe(RecipeSearchVO recipeSearchVO) {
		return modelMapper.convertToDTO(recipeDao.findAll(searchPredicateBuilderComponent.build(recipeSearchVO, RecipeSearchVO.class), recipeSearchVO), RecipeDTO.class);
	}

}
