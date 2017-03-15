package hu.lamsoft.hms.common.persistence.unit.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import hu.lamsoft.hms.common.persistence.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Quantity extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "unit_fk")
	private Unit unit;
	private Long longValue;
	private String stringValue;
	private Double doubleValue;
	
}
