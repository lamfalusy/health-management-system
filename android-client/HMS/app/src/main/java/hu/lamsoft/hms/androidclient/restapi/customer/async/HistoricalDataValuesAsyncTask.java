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
import hu.lamsoft.hms.androidclient.restapi.customer.dto.CustomerHistoricalDataValueDTO;

/**
 * Created by admin on 2017. 05. 01..
 */

public class HistoricalDataValuesAsyncTask extends HMSAsyncTask<Object, Integer, List<CustomerHistoricalDataValueDTO>> {

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private String historicalDataCode;
    private Date fromDate;
    private Date toDate;

    public HistoricalDataValuesAsyncTask(Date fromDate, Date toDate, String historicalDataCode, AsyncCallback<List<CustomerHistoricalDataValueDTO>> callback) {
        super(callback);
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.historicalDataCode = historicalDataCode;
    }

    @Override
    protected List<CustomerHistoricalDataValueDTO> doInBackground(Object... params) {
        try {
            final String url = BASE_URL+"/customer/secured/historical-data-values?fromDate="+dateFormat.format(fromDate)+"&toDate="+dateFormat.format(toDate)+"&historicalDataCode="+historicalDataCode;
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            return restTemplate.exchange(url, HttpMethod.GET, packageToSecuredHttpEntity(null), new ParameterizedTypeReference<List<CustomerHistoricalDataValueDTO>>(){}).getBody();
        } catch (Exception e) {
            Log.e("HistoricalDataValuesAT", e.getMessage(), e);
        }
        return null;
    }
}
