package hu.lamsoft.hms.androidclient.restapi.customer.async;

import android.util.Log;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import hu.lamsoft.hms.androidclient.restapi.common.async.AsyncCallback;
import hu.lamsoft.hms.androidclient.restapi.common.async.HMSAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.customer.dto.CustomerDTO;
import hu.lamsoft.hms.androidclient.restapi.customer.vo.LogedInCustomerVO;
import hu.lamsoft.hms.androidclient.restapi.customer.vo.LoginVO;

/**
 * Created by admin on 2017. 04. 15..
 */

public class LoginAsyncTask extends HMSAsyncTask<Object, Integer, LogedInCustomerVO> {

    private LoginVO loginVO;

    public LoginAsyncTask(LoginVO loginVO, AsyncCallback<LogedInCustomerVO> callback) {
        super(callback);
        this.loginVO = loginVO;
    }

    @Override
    protected LogedInCustomerVO doInBackground(Object... params) {
        try {
            final String url = BASE_URL+"/login";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, packageToHttpEntity(loginVO), String.class);
            LogedInCustomerVO ret = new LogedInCustomerVO();
            // ret.setCustomerDTO(responseEntity.getBody());
            ret.setToken(responseEntity.getHeaders().getAuthorization().substring(7));
            return ret;
        } catch (Exception e) {
            Log.e("LoginAsyncTask", e.getMessage(), e);
        }
        return null;
    }
}
