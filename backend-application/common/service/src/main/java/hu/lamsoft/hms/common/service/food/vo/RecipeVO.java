package hu.lamsoft.hms.common.service.food.vo;

import java.util.List;

import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class RecipeVO extends BaseVO {

	private String name;
	private String story;
	private String description;
	private List<RecipeComponentVO> components;
	
}
