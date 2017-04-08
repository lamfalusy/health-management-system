package hu.lamsoft.hms.regimen.persistence.regimen.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import hu.lamsoft.hms.common.persistence.customer.entity.Customer;
import hu.lamsoft.hms.common.persistence.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenForCustomer extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "customer_fk")
	private Customer customer;
	@OneToOne
	@JoinColumn(name = "regimen_fk")
	private Regimen regimen;
	private Date startDate;
	private Date endDate;
	
}
