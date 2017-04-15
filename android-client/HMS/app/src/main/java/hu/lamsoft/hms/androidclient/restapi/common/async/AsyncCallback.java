package hu.lamsoft.hms.androidclient.restapi.common.async;

import android.util.Log;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;
import hu.lamsoft.hms.androidclient.restapi.common.dto.Page;
import hu.lamsoft.hms.androidclient.restapi.food.dto.FoodDTO;

/**
 * Created by admin on 2017. 04. 15..
 */

public interface AsyncCallback<T> {

    void onPostExecute(T t);

}
