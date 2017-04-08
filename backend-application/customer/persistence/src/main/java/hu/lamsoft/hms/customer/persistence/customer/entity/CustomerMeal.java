package hu.lamsoft.hms.customer.persistence.customer.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import hu.lamsoft.hms.common.persistence.customer.entity.Customer;
import hu.lamsoft.hms.common.persistence.entity.BaseEntity;
import hu.lamsoft.hms.common.persistence.food.entity.Food;
import hu.lamsoft.hms.common.persistence.regimen.enums.Meal;
import hu.lamsoft.hms.common.persistence.unit.entity.Quantity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class CustomerMeal extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "customer_fk")
	private Customer customer;
	@Enumerated(EnumType.STRING)
	private Meal meal;
	private Date timeOfMeal;
	@OneToOne
	@JoinColumn(name = "quantity_fk")
	private Quantity quantity;
	@OneToOne
	@JoinColumn(name = "food_fk")
	private Food food;
	
}
