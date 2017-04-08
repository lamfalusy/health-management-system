package hu.lamsoft.hms.common.service.food.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import hu.lamsoft.hms.common.persistence.food.dao.FoodDao;
import hu.lamsoft.hms.common.service.food.FoodService;
import hu.lamsoft.hms.common.service.food.dto.FoodDTO;
import hu.lamsoft.hms.common.service.food.vo.FoodSearchVO;
import hu.lamsoft.hms.common.service.mapper.ModelMapper;
import hu.lamsoft.hms.common.service.search.impl.SearchPredicateBuilderComponent;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodDao foodDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private SearchPredicateBuilderComponent searchPredicateBuilderComponent;
	
	@Override
	public Page<FoodDTO> searchFood(FoodSearchVO foodSearchVO) {
		return modelMapper.convertToDTO(foodDao.findAll(searchPredicateBuilderComponent.build(foodSearchVO, FoodSearchVO.class), foodSearchVO), FoodDTO.class);
	}



}
