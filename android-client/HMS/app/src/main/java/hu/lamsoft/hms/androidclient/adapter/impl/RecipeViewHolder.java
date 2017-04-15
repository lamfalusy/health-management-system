package hu.lamsoft.hms.androidclient.adapter.impl;

import android.view.View;
import android.widget.TextView;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.adapter.ViewHolder;
import hu.lamsoft.hms.androidclient.restapi.food.dto.FoodDTO;
import hu.lamsoft.hms.androidclient.restapi.food.dto.RecipeDTO;

/**
 * Created by admin on 2017. 04. 15..
 */

public class RecipeViewHolder extends ViewHolder<RecipeDTO> {

    private TextView recipeName;

    public RecipeViewHolder(View view) {
        super(view);
        recipeName = (TextView) view.findViewById(R.id.recipe_name_text_view);
    }

    @Override
    public void setValues(RecipeDTO object) {
        recipeName.setText(object.getName());
    }

}
