package hu.lamsoft.hms.common.persistence.regimen.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import hu.lamsoft.hms.common.persistence.entity.BaseEntity;
import hu.lamsoft.hms.common.persistence.regimen.enums.Meal;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenDayMeal extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "regimen_day_fk")
	private RegimenDay regimenDay;
	@Enumerated(EnumType.STRING)
	private Meal meal;
	@OneToMany(mappedBy="regimenDayMeal", fetch=FetchType.LAZY)
	private List<RegimenDayMealItem> items;
	
}
