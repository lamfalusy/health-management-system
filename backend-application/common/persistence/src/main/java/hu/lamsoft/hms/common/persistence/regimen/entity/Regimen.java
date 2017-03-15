package hu.lamsoft.hms.common.persistence.regimen.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import hu.lamsoft.hms.common.persistence.entity.BaseEntity;
import hu.lamsoft.hms.common.persistence.nutritionist.entity.Nutritionist;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Regimen extends BaseEntity {

	private String name;
	@Lob
	private String description;
	@OneToOne
	@JoinColumn(name = "creator_fk")
	private Nutritionist creator;
	@OneToMany(mappedBy="regimen", fetch=FetchType.LAZY)
	private List<RegimenWeek> weeks;
	
}
