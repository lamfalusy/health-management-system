package hu.lamsoft.hms.nutritionist.service.nutritionist.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import hu.lamsoft.hms.common.service.search.vo.BaseSearchVO;
import lombok.Getter;

@Getter
public class NutritionistSearchVO extends BaseSearchVO {

	private static final long serialVersionUID = 1L;

	private String name;
	
	private String introduction;
	
	@JsonCreator
	public NutritionistSearchVO(@JsonProperty("page") int page,@JsonProperty("size") int size) {
		super(page, size);
	}
	
}
