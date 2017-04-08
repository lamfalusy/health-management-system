package hu.lamsoft.hms.regimen.persistence.regimen.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import hu.lamsoft.hms.common.persistence.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenWeek extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "regimen_fk")
	private Regimen regimen;
	@OneToMany(mappedBy="regimenWeek", fetch=FetchType.LAZY)
	private List<RegimenDayToWeek> regimenDayToWeeks;
	private Integer orderNumber;
	
}
