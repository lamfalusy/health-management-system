package hu.lamsoft.hms.androidclient.restapi.nutritionist.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class BlogEntryKeyWordDTO extends BaseDTO {

	@JsonIgnore
	private BlogEntryDTO blogEntry;
	private String keyWord;
	
}
