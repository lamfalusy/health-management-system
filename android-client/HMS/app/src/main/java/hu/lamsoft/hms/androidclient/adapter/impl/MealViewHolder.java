package hu.lamsoft.hms.androidclient.adapter.impl;

import android.view.View;
import android.widget.TextView;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.adapter.ViewHolder;
import hu.lamsoft.hms.androidclient.restapi.customer.dto.CustomerMealDTO;

/**
 * Created by admin on 2017. 05. 01..
 */

public class MealViewHolder extends ViewHolder<CustomerMealDTO>{

    private TextView name;

    public MealViewHolder(View view) {
        super(view);
        name = (TextView) view.findViewById(R.id.nutritionist_name_text_view);
    }

    @Override
    public void setValues(CustomerMealDTO object) {
        name.setText(object.getFood().getName());
    }

}
