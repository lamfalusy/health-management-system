package hu.lamsoft.hms.nutritionist.service.nutritionist.dto;

import java.util.List;

import hu.lamsoft.hms.common.service.dto.BaseDTO;
import hu.lamsoft.hms.common.service.nutritionist.dto.NutritionistDTO;
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
