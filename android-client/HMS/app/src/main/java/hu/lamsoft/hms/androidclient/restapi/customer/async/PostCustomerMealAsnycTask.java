package hu.lamsoft.hms.androidclient.restapi.customer.async;

import android.util.Log;

import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import hu.lamsoft.hms.androidclient.restapi.common.async.AsyncCallback;
import hu.lamsoft.hms.androidclient.restapi.common.async.HMSAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.customer.dto.CustomerMealDTO;

/**
 * Created by admin on 2017. 05. 01..
 */

public class PostCustomerMealAsnycTask extends HMSAsyncTask<Object, Integer, CustomerMealDTO> {

    private CustomerMealDTO customerMealDTO;

    public PostCustomerMealAsnycTask(CustomerMealDTO customerMealDTO, AsyncCallback<CustomerMealDTO> callback) {
        super(callback);
        this.customerMealDTO = customerMealDTO;
    }

    @Override
    protected CustomerMealDTO doInBackground(Object... params) {
        try {
            final String url = BASE_URL+"/customer/secured/customer-meal";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            return restTemplate.exchange(url, HttpMethod.POST, packageToSecuredHttpEntity(customerMealDTO), CustomerMealDTO.class).getBody();
        } catch (Exception e) {
            Log.e("PostCustomerMealAT", e.getMessage(), e);
        }
        return null;
    }
}
