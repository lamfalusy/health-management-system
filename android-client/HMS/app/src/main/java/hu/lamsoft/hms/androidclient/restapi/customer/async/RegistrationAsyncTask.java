package hu.lamsoft.hms.androidclient.restapi.customer.async;

import android.util.Log;

import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import hu.lamsoft.hms.androidclient.restapi.common.async.AsyncCallback;
import hu.lamsoft.hms.androidclient.restapi.common.async.HMSAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.customer.dto.CustomerDTO;
import hu.lamsoft.hms.androidclient.restapi.customer.vo.CustomerRegistrationVO;

/**
 * Created by admin on 2017. 04. 15..
 */

public class RegistrationAsyncTask extends HMSAsyncTask<Object, Integer, CustomerDTO> {

    private CustomerRegistrationVO customerRegistrationVO;

    public RegistrationAsyncTask(CustomerRegistrationVO customerRegistrationVO, AsyncCallback<CustomerDTO> callback) {
        super(callback);
        this.customerRegistrationVO = customerRegistrationVO;
    }

    @Override
    protected CustomerDTO doInBackground(Object... params) {
        try {
            final String url = BASE_URL+"/customer/registrate";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            return restTemplate.exchange(url, HttpMethod.POST, packageToHttpEntity(customerRegistrationVO), CustomerDTO.class).getBody();
        } catch (Exception e) {
            Log.e("RegistrationAsyncTask", e.getMessage(), e);
        }
        return null;
    }

}
