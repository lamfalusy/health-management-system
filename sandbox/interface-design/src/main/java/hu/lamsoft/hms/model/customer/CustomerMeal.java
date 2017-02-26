package hu.lamsoft.hms.model.customer;

import java.util.Date;

import hu.lamsoft.hms.model.food.Food;
import hu.lamsoft.hms.model.regimen.enums.Meal;
import hu.lamsoft.hms.model.unit.Quantity;

public class CustomerMeal {

	private Customer customer;
	private Meal meal;
	private Date timeOfMeal;
	private Quantity quantity;
	private Food food;
	
}
