package hu.lamsoft.hms.androidclient.adapter.impl;

import android.view.View;
import android.widget.TextView;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.adapter.ViewHolder;
import hu.lamsoft.hms.androidclient.restapi.customer.dto.CustomerHistoricalDataValueDTO;

/**
 * Created by admin on 2017. 05. 01..
 */

public class HistoricalDataViewHolder extends ViewHolder<CustomerHistoricalDataValueDTO>{

    private TextView name;

    public HistoricalDataViewHolder(View view) {
        super(view);
        name = (TextView) view.findViewById(R.id.historical_data_name_text_view);
    }

    @Override
    public void setValues(CustomerHistoricalDataValueDTO object) {
        name.setText(object.getCustomerHistoricalData().getCode());
    }

}
