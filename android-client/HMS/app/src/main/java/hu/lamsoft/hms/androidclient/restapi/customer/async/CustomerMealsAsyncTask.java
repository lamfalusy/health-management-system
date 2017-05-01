package hu.lamsoft.hms.androidclient.restapi.customer.async;

import android.util.Log;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import hu.lamsoft.hms.androidclient.restapi.common.async.AsyncCallback;
import hu.lamsoft.hms.androidclient.restapi.common.async.HMSAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.customer.dto.CustomerMealDTO;

/**
 * Created by admin on 2017. 05. 01..
 */

public class CustomerMealsAsyncTask extends HMSAsyncTask<Object, Integer, List<CustomerMealDTO>>{

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private Date fromDate;
    private Date toDate;

    public CustomerMealsAsyncTask(Date fromDate, Date toDate, AsyncCallback<List<CustomerMealDTO>> callback) {
        super(callback);
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    @Override
    protected List<CustomerMealDTO> doInBackground(Object... params) {
        try {
            final String url = BASE_URL+"/customer/secured/customer-meals?fromDate="+dateFormat.format(fromDate)+"&toDate="+dateFormat.format(toDate);
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            return restTemplate.exchange(url, HttpMethod.GET, packageToSecuredHttpEntity(null), new ParameterizedTypeReference<List<CustomerMealDTO>>(){}).getBody();
        } catch (Exception e) {
            Log.e("CustomerMealsAsyncTask", e.getMessage(), e);
        }
        return null;
    }

}
