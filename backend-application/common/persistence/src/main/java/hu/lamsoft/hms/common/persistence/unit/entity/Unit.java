package hu.lamsoft.hms.common.persistence.unit.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import hu.lamsoft.hms.common.persistence.entity.BaseEntity;
import hu.lamsoft.hms.common.persistence.unit.enums.UnitType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Unit extends BaseEntity {

	@Enumerated(EnumType.STRING)
	private UnitType type;
	private String name;
	private String shortName;
	
}
