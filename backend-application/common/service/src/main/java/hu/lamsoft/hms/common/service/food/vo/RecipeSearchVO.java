package hu.lamsoft.hms.common.service.food.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import hu.lamsoft.hms.common.service.search.vo.BaseSearchVO;
import lombok.Getter;

@Getter
public class RecipeSearchVO extends BaseSearchVO {

	private static final long serialVersionUID = 1L;
	
	private String name;

	private String story;

	private String description;

	private List<String> componentFoodNames;
	
	@JsonCreator
	public RecipeSearchVO(@JsonProperty("page") int page,@JsonProperty("size") int size) {
		super(page, size);
	}
	
}
