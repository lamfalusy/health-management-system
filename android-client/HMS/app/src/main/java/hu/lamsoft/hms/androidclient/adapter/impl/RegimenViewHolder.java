package hu.lamsoft.hms.androidclient.adapter.impl;

import android.view.View;
import android.widget.TextView;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.adapter.ViewHolder;
import hu.lamsoft.hms.androidclient.restapi.food.dto.FoodDTO;
import hu.lamsoft.hms.androidclient.restapi.regimen.dto.RegimenDTO;

/**
 * Created by admin on 2017. 04. 15..
 */

public class RegimenViewHolder extends ViewHolder<RegimenDTO> {

    private TextView regimenName;

    public RegimenViewHolder(View view) {
        super(view);
        regimenName = (TextView) view.findViewById(R.id.regimen_name_text_view);
    }

    @Override
    public void setValues(RegimenDTO object) {
        regimenName.setText(object.getName());
    }

}
