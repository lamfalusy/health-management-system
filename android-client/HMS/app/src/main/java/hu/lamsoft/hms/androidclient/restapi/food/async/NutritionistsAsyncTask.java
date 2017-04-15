package hu.lamsoft.hms.androidclient.restapi.food.async;

import org.springframework.core.ParameterizedTypeReference;

import hu.lamsoft.hms.androidclient.restapi.common.async.AsyncCallback;
import hu.lamsoft.hms.androidclient.restapi.common.async.DTOPagerAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.common.dto.Page;
import hu.lamsoft.hms.androidclient.restapi.food.dto.FoodDTO;
import hu.lamsoft.hms.androidclient.restapi.nutritionist.dto.NutritionistDTO;

/**
 * Created by admin on 2017. 04. 13..
 */

public class NutritionistsAsyncTask extends DTOPagerAsyncTask<NutritionistDTO> {

    public NutritionistsAsyncTask(AsyncCallback<Page<NutritionistDTO>> callback) {
        super(callback);
    }

    public NutritionistsAsyncTask(int page, AsyncCallback<Page<NutritionistDTO>> callback) {
        super(page, callback);
    }

    public NutritionistsAsyncTask(int page, int size, AsyncCallback<Page<NutritionistDTO>> callback) {
        super(page, size, callback);
    }

    @Override
    protected String getPath() {
        return "/nutritionist/nutritionists";
    }

    @Override
    protected ParameterizedTypeReference<Page<NutritionistDTO>> getParameterizedTypeReference() {
        return new ParameterizedTypeReference<Page<NutritionistDTO>>(){};
    }

}
