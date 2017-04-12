package hu.lamsoft.hms.nutritionist.service.nutritionist.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import hu.lamsoft.hms.common.service.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class BlogEntryKeyWordDTO extends BaseDTO {

	@JsonIgnore
	private BlogEntryDTO blogEntry;
	private String keyWord;
	
}
