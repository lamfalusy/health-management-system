package hu.lamsoft.hms.androidclient.restapi.food.dto;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;
import hu.lamsoft.hms.androidclient.restapi.unit.dto.QuantityDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class FoodDTO extends BaseDTO {

    private String name;
    private QuantityDTO energyInKcal;
    private QuantityDTO energyInKj;
    private QuantityDTO waterInG;
    private QuantityDTO proteinInG;
    private QuantityDTO carbohydratesInG;
    private QuantityDTO sugarInG;
    private QuantityDTO fatInG;
    private QuantityDTO saturatedFatInG;
    private QuantityDTO monounsaturatedFatInG;
    private QuantityDTO polyunsaturatedFatInG;
    private QuantityDTO cholesterolInMg;
    private QuantityDTO fiberInG;
    private QuantityDTO emotional;
    private QuantityDTO healthy;
    private RecipeDTO recipe;
    
}
