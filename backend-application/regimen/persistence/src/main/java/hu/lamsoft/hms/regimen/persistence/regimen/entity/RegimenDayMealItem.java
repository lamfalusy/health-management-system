package hu.lamsoft.hms.regimen.persistence.regimen.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import hu.lamsoft.hms.common.persistence.entity.BaseEntity;
import hu.lamsoft.hms.common.persistence.food.entity.Food;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenDayMealItem extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "regimen_day_meal_fk")
	private RegimenDayMeal regimenDayMeal;
	@OneToOne
	@JoinColumn(name = "food_fk")
	private Food food;
	
}
