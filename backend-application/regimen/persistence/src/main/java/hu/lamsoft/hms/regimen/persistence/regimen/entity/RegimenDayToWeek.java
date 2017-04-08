package hu.lamsoft.hms.regimen.persistence.regimen.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import hu.lamsoft.hms.common.persistence.entity.BaseEntity;
import hu.lamsoft.hms.regimen.persistence.regimen.enums.DaysOfWeek;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenDayToWeek extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "regimen_week_fk")
	private RegimenWeek regimenWeek;
	@OneToOne
	@JoinColumn(name = "regimen_day_fk")
	private RegimenDay regimenDay;
	@Enumerated(EnumType.STRING)
	private DaysOfWeek dayOfWeek;
	
}
