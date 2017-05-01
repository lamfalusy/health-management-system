package hu.lamsoft.hms.androidclient.restapi.customer.async;

import android.util.Log;

import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import hu.lamsoft.hms.androidclient.restapi.common.async.AsyncCallback;
import hu.lamsoft.hms.androidclient.restapi.common.async.HMSAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.customer.dto.CustomerDTO;
import hu.lamsoft.hms.androidclient.restapi.customer.dto.CustomerHistoricalDataValueDTO;

/**
 * Created by admin on 2017. 05. 01..
 */

public class PostHistoricalDataAsnycTask extends HMSAsyncTask<Object, Integer, CustomerHistoricalDataValueDTO> {

    private CustomerHistoricalDataValueDTO customerHistoricalDataValueDTO;

    public PostHistoricalDataAsnycTask(CustomerHistoricalDataValueDTO customerHistoricalDataValueDT, AsyncCallback<CustomerHistoricalDataValueDTO> callback) {
        super(callback);
        this.customerHistoricalDataValueDTO = customerHistoricalDataValueDT;
    }

    @Override
    protected CustomerHistoricalDataValueDTO doInBackground(Object... params) {
        try {
            final String url = BASE_URL+"/customer/secured/historical-data-value";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            return restTemplate.exchange(url, HttpMethod.POST, packageToSecuredHttpEntity(customerHistoricalDataValueDTO), CustomerHistoricalDataValueDTO.class).getBody();
        } catch (Exception e) {
            Log.e("PostHistoricalDataAT", e.getMessage(), e);
        }
        return null;
    }
}
