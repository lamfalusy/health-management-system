package hu.lamsoft.hms.androidclient.restapi.common.async;

import android.os.AsyncTask;

import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import hu.lamsoft.hms.androidclient.component.session.Session;

/**
 * Created by admin on 2017. 04. 15..
 */

public abstract class HMSAsyncTask<K,T,L> extends AsyncTask<K,T,L> {

    protected static final String BASE_URL = "https://192.168.0.49";

    protected AsyncCallback<L> callback;

    public HMSAsyncTask(AsyncCallback<L> callback) {
        this.callback = callback;
    }

    @Override
    protected void onPostExecute(L l) {
        super.onPostExecute(l);
        callback.onPostExecute(l);
    }

    protected <T> HttpEntity packageToHttpEntity(T t) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity(t, headers);
    }

    protected <T> HttpEntity packageToSecuredHttpEntity(T t) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAuthorization(Session.instance.getAuthenticationManager().getHttpAuthentication());
        return new HttpEntity(t, headers);
    }

}
