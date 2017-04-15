package hu.lamsoft.hms.androidclient.restapi.food.async;

import org.springframework.core.ParameterizedTypeReference;

import hu.lamsoft.hms.androidclient.restapi.common.async.AsyncCallback;
import hu.lamsoft.hms.androidclient.restapi.common.async.DTOPagerAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.common.dto.Page;
import hu.lamsoft.hms.androidclient.restapi.food.dto.FoodDTO;

/**
 * Created by admin on 2017. 04. 13..
 */

public class FoodsAsyncTask extends DTOPagerAsyncTask<FoodDTO> {

    public FoodsAsyncTask(AsyncCallback<Page<FoodDTO>> callback) {
        super(callback);
    }

    public FoodsAsyncTask(int page, AsyncCallback<Page<FoodDTO>> callback) {
        super(page, callback);
    }

    public FoodsAsyncTask(int page, int size, AsyncCallback<Page<FoodDTO>> callback) {
        super(page, size, callback);
    }

    @Override
    protected String getPath() {
        return "/food/foods";
    }

    @Override
    protected ParameterizedTypeReference<Page<FoodDTO>> getParameterizedTypeReference() {
        return new ParameterizedTypeReference<Page<FoodDTO>>(){};
    }

}
