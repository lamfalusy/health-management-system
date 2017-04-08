package hu.lamsoft.hms.regimen.persistence.regimen.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import hu.lamsoft.hms.common.persistence.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class RegimenDay extends BaseEntity {

	private String name;
	@OneToMany(mappedBy="regimenDay", fetch=FetchType.LAZY)
	private List<RegimenDayMeal> meals;
	
}
