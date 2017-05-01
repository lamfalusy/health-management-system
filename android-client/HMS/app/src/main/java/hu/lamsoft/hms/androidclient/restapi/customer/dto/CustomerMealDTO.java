package hu.lamsoft.hms.androidclient.restapi.customer.dto;

import java.util.Date;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;
import hu.lamsoft.hms.androidclient.restapi.food.dto.FoodDTO;
import hu.lamsoft.hms.androidclient.restapi.regimen.enums.Meal;
import hu.lamsoft.hms.androidclient.restapi.unit.dto.QuantityDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CustomerMealDTO extends BaseDTO {

    private CustomerDTO customer;
    private Meal meal;
    private Date timeOfMeal;
    private QuantityDTO quantity;
    private FoodDTO food;

}
