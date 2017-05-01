package hu.lamsoft.hms.androidclient.restapi.regimen.async;

import org.springframework.core.ParameterizedTypeReference;

import hu.lamsoft.hms.androidclient.restapi.common.async.AsyncCallback;
import hu.lamsoft.hms.androidclient.restapi.common.async.DTOPagerAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.common.dto.Page;
import hu.lamsoft.hms.androidclient.restapi.food.dto.FoodDTO;
import hu.lamsoft.hms.androidclient.restapi.regimen.dto.RegimenDTO;

/**
 * Created by admin on 2017. 04. 13..
 */

public class RegimensAsyncTask extends DTOPagerAsyncTask<RegimenDTO> {

    public RegimensAsyncTask(AsyncCallback<Page<RegimenDTO>> callback) {
        super(callback);
    }

    public RegimensAsyncTask(int page, AsyncCallback<Page<RegimenDTO>> callback) {
        super(page, callback);
    }

    public RegimensAsyncTask(int page, int size, AsyncCallback<Page<RegimenDTO>> callback) {
        super(page, size, callback);
    }

    @Override
    protected String getPath() {
        return "/regimen/regimens";
    }

    @Override
    protected ParameterizedTypeReference<Page<RegimenDTO>> getParameterizedTypeReference() {
        return new ParameterizedTypeReference<Page<RegimenDTO>>(){};
    }

}
