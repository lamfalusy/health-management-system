package hu.lamsoft.hms.common.persistence.recipe.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import hu.lamsoft.hms.common.persistence.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=true)
public class Recipe extends BaseEntity {

	private String name;
	@Lob
	private String story;
	@Lob
	private String description;
	@OneToMany(mappedBy="recipe", fetch=FetchType.LAZY)
	private List<RecipeComponent> components;
	
}
