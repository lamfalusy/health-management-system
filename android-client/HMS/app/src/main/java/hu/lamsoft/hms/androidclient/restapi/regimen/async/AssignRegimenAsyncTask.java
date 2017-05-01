package hu.lamsoft.hms.androidclient.restapi.regimen.async;

import android.util.Log;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import hu.lamsoft.hms.androidclient.restapi.common.async.AsyncCallback;
import hu.lamsoft.hms.androidclient.restapi.common.async.HMSAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.customer.vo.LogedInCustomerVO;
import hu.lamsoft.hms.androidclient.restapi.regimen.dto.RegimenForCustomerDTO;

/**
 * Created by admin on 2017. 05. 01..
 */

public class AssignRegimenAsyncTask extends HMSAsyncTask<Object, Integer, RegimenForCustomerDTO> {

    private RegimenForCustomerDTO regimenForCustomerDTO;

    public AssignRegimenAsyncTask(RegimenForCustomerDTO regimenForCustomerDTO, AsyncCallback<RegimenForCustomerDTO> callback) {
        super(callback);
        this.regimenForCustomerDTO = regimenForCustomerDTO;
    }

    @Override
    protected RegimenForCustomerDTO doInBackground(Object... params) {
        try {
            final String url = BASE_URL+"/assign-regimen";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity<RegimenForCustomerDTO> responseEntity = restTemplate.exchange(url, HttpMethod.POST, packageToHttpEntity(regimenForCustomerDTO), RegimenForCustomerDTO.class);
            return responseEntity.getBody();
        } catch (Exception e) {
            Log.e("AssignRegimenAsyncTask", e.getMessage(), e);
        }
        return null;
    }
}
