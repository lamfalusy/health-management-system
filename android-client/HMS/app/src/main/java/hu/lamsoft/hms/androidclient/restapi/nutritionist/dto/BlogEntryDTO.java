package hu.lamsoft.hms.androidclient.restapi.nutritionist.dto;

import java.util.List;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class BlogEntryDTO extends BaseDTO {

	private NutritionistDTO writer;
	private String title;
	private String preface;
	private String content;
	private List<BlogEntryKeyWordDTO> keyWords;
	
}
