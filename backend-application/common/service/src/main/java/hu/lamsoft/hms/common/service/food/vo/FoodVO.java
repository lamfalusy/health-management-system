package hu.lamsoft.hms.common.service.food.vo;

import hu.lamsoft.hms.common.service.unit.vo.QuantityVO;
import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class FoodVO extends BaseVO {

    private String name;
    private QuantityVO energyInKcal;
    private QuantityVO energyInKj;
    private QuantityVO waterInG;
    private QuantityVO proteinInG;
    private QuantityVO carbohydratesInG;
    private QuantityVO sugarInG;
    private QuantityVO fatInG;
    private QuantityVO saturatedFatInG;
    private QuantityVO monounsaturatedFatInG;
    private QuantityVO polyunsaturatedFatInG;
    private QuantityVO cholesterolInMg;
    private QuantityVO fiberInG;
    private QuantityVO emotional;
    private QuantityVO healthy;
    private RecipeVO recipe;
    
}
