package hu.lamsoft.hms.customer.persistence.customer.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import hu.lamsoft.hms.common.persistence.entity.BaseEntity;
import hu.lamsoft.hms.common.persistence.unit.entity.Unit;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class CustomerHistoricalData extends BaseEntity {

	private String code;
	@OneToOne
	@JoinColumn(name = "unit_fk")
	private Unit unit;
	
}
