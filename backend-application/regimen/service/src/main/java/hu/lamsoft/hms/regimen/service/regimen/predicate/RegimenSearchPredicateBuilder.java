package hu.lamsoft.hms.regimen.service.regimen.predicate;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;

import hu.lamsoft.hms.common.service.search.annotation.PredicateBuilder;
import hu.lamsoft.hms.common.service.search.impl.AbstractSearchPredicateBuilder;
import hu.lamsoft.hms.regimen.persistence.regimen.entity.QRegimen;
import hu.lamsoft.hms.regimen.service.regimen.vo.RegimenSearchVO;

@PredicateBuilder
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
