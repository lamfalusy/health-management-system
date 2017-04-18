package hu.lamsoft.hms.androidclient.restapi.customer.async;

import android.util.Log;

import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import hu.lamsoft.hms.androidclient.restapi.common.async.AsyncCallback;
import hu.lamsoft.hms.androidclient.restapi.common.async.HMSAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.customer.dto.CustomerDTO;

/**
 * Created by admin on 2017. 04. 15..
 */

public class CustomerAsyncTask extends HMSAsyncTask<Object, Integer, CustomerDTO> {

    public CustomerAsyncTask(AsyncCallback<CustomerDTO> callback) {
        super(callback);
    }

    @Override
    protected CustomerDTO doInBackground(Object... params) {
        try {
            final String url = BASE_URL+"/customer/secured/customer";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            return restTemplate.exchange(url, HttpMethod.GET, packageToSecuredHttpEntity(null), CustomerDTO.class).getBody();
        } catch (Exception e) {
            Log.e("CustomerAsyncTask", e.getMessage(), e);
        }
        return null;
    }
}
