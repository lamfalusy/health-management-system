package hu.lamsoft.hms.common.service.regimen.impl;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;

import hu.lamsoft.hms.common.persistence.regimen.entity.QRegimen;
import hu.lamsoft.hms.common.service.regimen.vo.RegimenSearchVO;
import hu.lamsoft.hms.common.service.search.impl.AbstractSearchPredicateBuilder;

public class RegimenSearchPredicateBuilder extends AbstractSearchPredicateBuilder<RegimenSearchVO> {

	@Override
	public Predicate build(RegimenSearchVO regimenSearch) {
		BooleanBuilder builder = new BooleanBuilder();
		addLikePredicate(builder, regimenSearch.getName(), QRegimen.regimen.name);
		addLikePredicate(builder, regimenSearch.getDescription(), QRegimen.regimen.description);
		addLikePredicate(builder, regimenSearch.getCreatorName(), QRegimen.regimen.creator.customer.firstname.concat(" ").concat(QRegimen.regimen.creator.customer.lastname));
		return builder;
	}

}
