package hu.lamsoft.hms.common.service.nutritionist;

import org.springframework.data.domain.Page;

import hu.lamsoft.hms.common.service.nutritionist.dto.NutritionistDTO;
import hu.lamsoft.hms.common.service.nutritionist.vo.NutritionistSearchVO;

public interface NutritionistService {

	NutritionistDTO registrate(NutritionistDTO nutritionist);
	
	Page<NutritionistDTO> searchNutritionist(NutritionistSearchVO nutritionistSearchVO);
	
}
