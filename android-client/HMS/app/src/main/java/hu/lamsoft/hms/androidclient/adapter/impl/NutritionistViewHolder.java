package hu.lamsoft.hms.androidclient.adapter.impl;

import android.view.View;
import android.widget.TextView;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.adapter.ViewHolder;
import hu.lamsoft.hms.androidclient.restapi.food.dto.FoodDTO;
import hu.lamsoft.hms.androidclient.restapi.nutritionist.dto.NutritionistDTO;

/**
 * Created by admin on 2017. 04. 15..
 */

public class NutritionistViewHolder extends ViewHolder<NutritionistDTO> {

    private TextView nutritionistName;

    public NutritionistViewHolder(View view) {
        super(view);
        nutritionistName = (TextView) view.findViewById(R.id.nutritionist_name_text_view);
    }

    @Override
    public void setValues(NutritionistDTO object) {
        nutritionistName.setText(object.getCustomer().getFirstname()+" "+object.getCustomer().getLastname());
    }

}
