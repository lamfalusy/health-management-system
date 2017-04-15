package hu.lamsoft.hms.androidclient.adapter;

import android.view.View;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;

/**
 * Created by admin on 2017. 04. 15..
 */

public abstract class ViewHolder<T extends BaseDTO> {

    public ViewHolder(View view) {
        // Nothing to do here
    }

    public abstract void setValues(T object);

}
