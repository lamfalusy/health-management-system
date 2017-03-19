package hu.lamsoft.hms.common.service.nutritionist.vo;

import hu.lamsoft.hms.common.service.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class BlogEntryKeyWordVO extends BaseVO {

	private BlogEntryVO blogEntry;
	private String keyWord;
	
}
