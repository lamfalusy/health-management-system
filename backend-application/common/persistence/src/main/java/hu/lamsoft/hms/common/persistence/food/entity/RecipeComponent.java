package hu.lamsoft.hms.common.persistence.food.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import hu.lamsoft.hms.common.persistence.entity.BaseEntity;
import hu.lamsoft.hms.common.persistence.unit.entity.Quantity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class RecipeComponent extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "recipe_fk")
	private Recipe recipe;
	@OneToOne
	@JoinColumn(name = "food_fk")
	private Food food;
	@OneToOne
	@JoinColumn(name = "quantity_fk")
	private Quantity quantity;
	
}
