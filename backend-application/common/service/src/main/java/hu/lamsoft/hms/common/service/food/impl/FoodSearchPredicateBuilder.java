package hu.lamsoft.hms.common.service.food.impl;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;

import hu.lamsoft.hms.common.persistence.food.entity.QFood;
import hu.lamsoft.hms.common.service.food.vo.FoodSearchVO;
import hu.lamsoft.hms.common.service.search.impl.AbstractSearchPredicateBuilder;

public class FoodSearchPredicateBuilder extends AbstractSearchPredicateBuilder<FoodSearchVO> {

	@Override
	public Predicate build(FoodSearchVO foodSearchVO) {
		BooleanBuilder builder = new BooleanBuilder();
		addLikePredicate(builder, foodSearchVO.getName(), QFood.food.name);
		addIntervalPredicates(builder, foodSearchVO.getEnergyInKcalGT(), foodSearchVO.getEnergyInKcalLT(), QFood.food.energyInKcal.doubleValue);
		addIntervalPredicates(builder, foodSearchVO.getEnergyInKjGT(), foodSearchVO.getEnergyInKjLT(), QFood.food.energyInKj.doubleValue);
		addIntervalPredicates(builder, foodSearchVO.getWaterInGGT(), foodSearchVO.getWaterInGLT(), QFood.food.waterInG.doubleValue);
		addIntervalPredicates(builder, foodSearchVO.getProteinInGGT(), foodSearchVO.getProteinInGLT(), QFood.food.proteinInG.doubleValue);
		addIntervalPredicates(builder, foodSearchVO.getCarbohydratesInGGT(), foodSearchVO.getCarbohydratesInGLT(), QFood.food.carbohydratesInG.doubleValue);
		addIntervalPredicates(builder, foodSearchVO.getSugarInGGT(), foodSearchVO.getSugarInGLT(), QFood.food.sugarInG.doubleValue);
	    addIntervalPredicates(builder, foodSearchVO.getFatInGGT(), foodSearchVO.getFatInGLT(), QFood.food.fatInG.doubleValue);
	    addIntervalPredicates(builder, foodSearchVO.getSaturatedFatInGGT(), foodSearchVO.getSaturatedFatInGLT(), QFood.food.saturatedFatInG.doubleValue);
	    addIntervalPredicates(builder, foodSearchVO.getMonounsaturatedFatInGGT(), foodSearchVO.getMonounsaturatedFatInGLT(), QFood.food.monounsaturatedFatInG.doubleValue);
	    addIntervalPredicates(builder, foodSearchVO.getPolyunsaturatedFatInGGT(), foodSearchVO.getPolyunsaturatedFatInGLT(), QFood.food.polyunsaturatedFatInG.doubleValue);
	    addIntervalPredicates(builder, foodSearchVO.getCholesterolInMgGT(), foodSearchVO.getCholesterolInMgLT(), QFood.food.cholesterolInMg.doubleValue);
	    addIntervalPredicates(builder, foodSearchVO.getFiberInGGT(), foodSearchVO.getFiberInGLT(), QFood.food.fiberInG.doubleValue);
	    addIntervalPredicates(builder, foodSearchVO.getEmotionalGT(), foodSearchVO.getEmotionalLT(), QFood.food.emotional.doubleValue);
	    addIntervalPredicates(builder, foodSearchVO.getHealthyGT(), foodSearchVO.getHealthyLT(), QFood.food.healthy.doubleValue);
	    addHasPredicate(builder, foodSearchVO.getHasRecipe(), QFood.food.recipe);
		return builder;
	}

}
