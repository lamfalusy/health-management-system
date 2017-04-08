package hu.lamsoft.hms.nutritionist.service.nutritionist.dto;

import hu.lamsoft.hms.common.service.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class BlogEntryKeyWordDTO extends BaseDTO {

	private BlogEntryDTO blogEntry;
	private String keyWord;
	
}
