package hu.lamsoft.hms.androidclient.restapi.common.async;

import android.util.Log;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;
import hu.lamsoft.hms.androidclient.restapi.common.dto.Page;

/**
 * Created by admin on 2017. 04. 15..
 */

public abstract class DTOPagerAsyncTask<T extends BaseDTO> extends HMSAsyncTask<Object, Integer, Page<T>> {

    private int page = 0;
    private int size = 25;

    public DTOPagerAsyncTask(AsyncCallback<Page<T>> callback) {
        super(callback);
    }

    public DTOPagerAsyncTask(int page, AsyncCallback<Page<T>> callback) {
        super(callback);
        this.page = page;
    }

    public DTOPagerAsyncTask(int page, int size, AsyncCallback<Page<T>> callback) {
        super(callback);
        this.page = page;
        this.size = size;
    }

    @Override
    protected Page<T> doInBackground(Object... params) {
        try {
            final String url = BASE_URL+getPath()+"?page="+page+"&size="+size;
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            return restTemplate.exchange(url, HttpMethod.GET, null, getParameterizedTypeReference()).getBody();
        } catch (Exception e) {
            Log.e("DTOPagerAsyncTask", e.getMessage(), e);
        }
        return null;
    }

    protected abstract String getPath();

    protected abstract ParameterizedTypeReference<Page<T>> getParameterizedTypeReference();

}
