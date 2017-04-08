package hu.lamsoft.hms.common.service.nutritionist.predicate;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;

import hu.lamsoft.hms.common.persistence.nutritionist.entity.QNutritionist;
import hu.lamsoft.hms.common.service.nutritionist.vo.NutritionistSearchVO;
import hu.lamsoft.hms.common.service.search.impl.AbstractSearchPredicateBuilder;

public class NutritionistSearchPredicateBuilder extends AbstractSearchPredicateBuilder<NutritionistSearchVO> {

	@Override
	public Predicate build(NutritionistSearchVO nutritionistSearchVO) {
		BooleanBuilder builder = new BooleanBuilder();
		addLikePredicate(builder, nutritionistSearchVO.getName(), QNutritionist.nutritionist.customer.firstname.concat(" ").concat(QNutritionist.nutritionist.customer.lastname));
		addLikePredicate(builder, nutritionistSearchVO.getIntroduction(), QNutritionist.nutritionist.introduction);
		return builder;
	}

}
