package hu.lamsoft.hms.common.service.search.vo;

import org.springframework.data.domain.PageRequest;

public class BaseSearchVO extends PageRequest {

	private static final long serialVersionUID = 1L;
	
	public BaseSearchVO(int page, int size) {
		super(page, size);
	}
	
}
