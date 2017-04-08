package hu.lamsoft.hms.common.service.food.dto;

import java.util.List;

import hu.lamsoft.hms.common.service.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RecipeDTO extends BaseDTO {

	private String name;
	private String story;
	private String description;
	private List<RecipeComponentDTO> components;
	
}
