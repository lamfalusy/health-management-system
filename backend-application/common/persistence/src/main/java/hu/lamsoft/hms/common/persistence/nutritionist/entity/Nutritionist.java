package hu.lamsoft.hms.common.persistence.nutritionist.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import hu.lamsoft.hms.common.persistence.customer.entity.Customer;
import hu.lamsoft.hms.common.persistence.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Nutritionist extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "customer_fk")
	private Customer customer;
	@Lob
	private String introduction;
	
}
