package hu.lamsoft.hms.androidclient.restapi.unit.async;

import android.util.Log;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import hu.lamsoft.hms.androidclient.restapi.common.async.AsyncCallback;
import hu.lamsoft.hms.androidclient.restapi.common.async.HMSAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.customer.dto.CustomerHistoricalDataDTO;
import hu.lamsoft.hms.androidclient.restapi.unit.dto.UnitDTO;

/**
 * Created by admin on 2017. 05. 01..
 */

public class UnitAsyncTask extends HMSAsyncTask<Object, Integer, List<UnitDTO>> {

    public UnitAsyncTask(AsyncCallback<List<UnitDTO>> callback) {
        super(callback);
    }

    @Override
    protected List<UnitDTO> doInBackground(Object... params) {
        try {
            final String url = BASE_URL+"/customer/secured/units";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            return restTemplate.exchange(url, HttpMethod.GET, packageToSecuredHttpEntity(null), new ParameterizedTypeReference<List<UnitDTO>>(){}).getBody();
        } catch (Exception e) {
            Log.e("HistoricalDataValuesAT", e.getMessage(), e);
        }
        return null;
    }
}
