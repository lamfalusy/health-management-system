package hu.lamsoft.hms.common.service.nutritionist.vo;

import java.util.List;

import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class BlogEntryVO extends BaseVO {

	private NutritionistVO writer;
	private String title;
	private String preface;
	private String content;
	private List<BlogEntryKeyWordVO> keyWords;
	
}
