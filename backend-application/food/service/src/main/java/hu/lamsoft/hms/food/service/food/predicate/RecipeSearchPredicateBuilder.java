package hu.lamsoft.hms.food.service.food.predicate;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;

import hu.lamsoft.hms.common.persistence.food.entity.QRecipe;
import hu.lamsoft.hms.common.service.search.annotation.PredicateBuilder;
import hu.lamsoft.hms.common.service.search.impl.AbstractSearchPredicateBuilder;
import hu.lamsoft.hms.food.service.food.vo.RecipeSearchVO;

@PredicateBuilder
public class RecipeSearchPredicateBuilder extends AbstractSearchPredicateBuilder<RecipeSearchVO> {

	@Override
	public Predicate build(RecipeSearchVO recipeSearchVO) {
		BooleanBuilder builder = new BooleanBuilder();
		addLikePredicate(builder, recipeSearchVO.getName(), QRecipe.recipe.name);
		addLikePredicate(builder, recipeSearchVO.getStory(), QRecipe.recipe.story);
		addLikePredicate(builder, recipeSearchVO.getDescription(), QRecipe.recipe.description);
		addInPredicate(builder, recipeSearchVO.getComponentFoodNames(), QRecipe.recipe.components.any().food.name);
		return builder;
	}
	
}
