package hu.lamsoft.hms.common.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import hu.lamsoft.hms.common.persistence.entity.BaseEntity;
import hu.lamsoft.hms.common.service.vo.BaseVO;

@Component
public class ModelMapper {

	private org.modelmapper.ModelMapper modelMapper = new org.modelmapper.ModelMapper();
	
	public <T extends BaseVO> T convertToVO(BaseEntity entity, Class<T> targetClass) {
		return modelMapper.map(entity, targetClass);
	}
	
	public <T extends BaseEntity> T convertToEntity(BaseVO vo, Class<T> targetClass) {
		return modelMapper.map(vo, targetClass);
	}
	
	public <T extends BaseVO, S extends BaseEntity> List<T> convertToVO(List<S> entities, Class<T> targetClass) {
		return entities.stream().map(entity -> convertToVO(entity, targetClass)).collect(Collectors.toList());
	}
	
	public <T extends BaseEntity, S extends BaseVO> List<T> convertToEntity(List<S> vos, Class<T> targetClass) {
		return vos.stream().map(vo -> convertToEntity(vo, targetClass)).collect(Collectors.toList());
	}
	
	public <T extends BaseVO, S extends BaseEntity> Page<T> convertToVO(Page<S> entities, Class<T> targetClass) {
		return entities.map(entity -> convertToVO(entity, targetClass));
	}
	
}
