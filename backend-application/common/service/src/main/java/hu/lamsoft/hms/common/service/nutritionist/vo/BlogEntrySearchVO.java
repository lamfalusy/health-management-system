package hu.lamsoft.hms.common.service.nutritionist.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import hu.lamsoft.hms.common.service.search.vo.BaseSearchVO;
import lombok.Getter;

@Getter
public class BlogEntrySearchVO extends BaseSearchVO {

	private static final long serialVersionUID = 1L;

	private String writerName;
	
	private String title;
	
	private String preface;
	
	private String content;
	
	private List<String> keyWords;
	
	@JsonCreator
	public BlogEntrySearchVO(@JsonProperty("page") int page,@JsonProperty("size") int size) {
		super(page, size);
	}
	
}
