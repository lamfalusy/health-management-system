package hu.lamsoft.hms.androidclient.adapter.impl;

import android.view.View;
import android.widget.TextView;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.adapter.ViewHolder;
import hu.lamsoft.hms.androidclient.restapi.food.dto.FoodDTO;

/**
 * Created by admin on 2017. 04. 15..
 */

public class FoodViewHolder extends ViewHolder<FoodDTO> {

    private TextView foodName;

    public FoodViewHolder(View view) {
        super(view);
        foodName = (TextView) view.findViewById(R.id.food_name_text_view);
    }

    @Override
    public void setValues(FoodDTO object) {
        foodName.setText(object.getName());
    }

}
