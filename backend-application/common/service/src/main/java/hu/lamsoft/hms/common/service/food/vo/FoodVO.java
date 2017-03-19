package hu.lamsoft.hms.common.service.food.vo;

import hu.lamsoft.hms.common.persistence.recipe.entity.Recipe;
import hu.lamsoft.hms.common.persistence.unit.entity.Quantity;
import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class FoodVO extends BaseVO {

    private String name;
    private Quantity energyInKcal;
    private Quantity energyInKj;
    private Quantity waterInG;
    private Quantity proteinInG;
    private Quantity carbohydratesInG;
    private Quantity sugarInG;
    private Quantity fatInG;
    private Quantity saturatedFatInG;
    private Quantity monounsaturatedFatInG;
    private Quantity polyunsaturatedFatInG;
    private Quantity cholesterolInMg;
    private Quantity fiberInG;
    private Quantity emotional;
    private Quantity healthy;
    private Recipe recipe;
    
}
