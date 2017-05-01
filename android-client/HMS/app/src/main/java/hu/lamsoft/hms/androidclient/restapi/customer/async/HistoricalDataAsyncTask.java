package hu.lamsoft.hms.androidclient.restapi.customer.async;

import android.util.Log;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import hu.lamsoft.hms.androidclient.restapi.common.async.AsyncCallback;
import hu.lamsoft.hms.androidclient.restapi.common.async.HMSAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.customer.dto.CustomerHistoricalDataDTO;

/**
 * Created by admin on 2017. 05. 01..
 */

public class HistoricalDataAsyncTask extends HMSAsyncTask<Object, Integer, List<CustomerHistoricalDataDTO>> {

    public HistoricalDataAsyncTask(AsyncCallback<List<CustomerHistoricalDataDTO>> callback) {
        super(callback);
    }

    @Override
    protected List<CustomerHistoricalDataDTO> doInBackground(Object... params) {
        try {
            final String url = BASE_URL+"/customer/secured/historical-datas";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            return restTemplate.exchange(url, HttpMethod.GET, packageToSecuredHttpEntity(null), new ParameterizedTypeReference<List<CustomerHistoricalDataDTO>>(){}).getBody();
        } catch (Exception e) {
            Log.e("HistoricalDataValuesAT", e.getMessage(), e);
        }
        return null;
    }
}
