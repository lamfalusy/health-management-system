package hu.lamsoft.hms.regimen.service.regimen.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import hu.lamsoft.hms.common.service.search.vo.BaseSearchVO;
import lombok.Getter;

@Getter
public class RegimenSearchVO extends BaseSearchVO {

	private static final long serialVersionUID = 1L;

	private String name;
	
	private String description;
	
	private String creatorName;
	
	@JsonCreator
	public RegimenSearchVO(@JsonProperty("page") int page,@JsonProperty("size") int size) {
		super(page, size);
	}
	
}
