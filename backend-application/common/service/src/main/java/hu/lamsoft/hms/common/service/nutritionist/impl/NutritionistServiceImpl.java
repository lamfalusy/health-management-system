package hu.lamsoft.hms.common.service.nutritionist.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import hu.lamsoft.hms.common.persistence.customer.dao.CustomerDao;
import hu.lamsoft.hms.common.persistence.nutritionist.dao.NutritionistDao;
import hu.lamsoft.hms.common.persistence.nutritionist.entity.Nutritionist;
import hu.lamsoft.hms.common.service.mapper.ModelMapper;
import hu.lamsoft.hms.common.service.nutritionist.NutritionistService;
import hu.lamsoft.hms.common.service.nutritionist.vo.NutritionistSearchVO;
import hu.lamsoft.hms.common.service.nutritionist.vo.NutritionistVO;
import hu.lamsoft.hms.common.service.search.impl.SearchPredicateBuilderComponent;

@Service
@Transactional
public class NutritionistServiceImpl implements NutritionistService {

	@Autowired
	private NutritionistDao nutritionistDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private SearchPredicateBuilderComponent searchPredicateBuilderComponent;
	
	@Override
	public NutritionistVO registrate(NutritionistVO nutritionist) {
		Assert.notNull(nutritionist);
		Assert.notNull(nutritionist.getCustomer());
		Assert.notNull(nutritionist.getCustomer().getId());
		Nutritionist entity = new Nutritionist();
		entity.setIntroduction(nutritionist.getIntroduction());
		entity.setCustomer(customerDao.findOne(nutritionist.getCustomer().getId()));
		return modelMapper.convertToVO(nutritionistDao.save(entity), NutritionistVO.class);
	}

	@Override
	public Page<NutritionistVO> searchNutritionist(NutritionistSearchVO nutritionistSearchVO) {
		return modelMapper.convertToVO(nutritionistDao.findAll(searchPredicateBuilderComponent.build(nutritionistSearchVO, NutritionistSearchVO.class), nutritionistSearchVO), NutritionistVO.class);
	}

}
