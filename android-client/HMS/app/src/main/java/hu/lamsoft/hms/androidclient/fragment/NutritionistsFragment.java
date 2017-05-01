package hu.lamsoft.hms.androidclient.fragment;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.activity.NutritionistActivity;
import hu.lamsoft.hms.androidclient.adapter.impl.NutritionistViewHolder;
import hu.lamsoft.hms.androidclient.restapi.nutritionist.async.NutritionistsAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.nutritionist.dto.NutritionistDTO;

public class NutritionistsFragment extends DTOListFragment<NutritionistDTO, NutritionistViewHolder, NutritionistsAsyncTask> {

    public NutritionistsFragment() {
        super(NutritionistViewHolder.class, NutritionistsAsyncTask.class, R.layout.fragment_nutritionists, R.id.nutritionists_list_view, R.layout.list_item_nutritionist, NutritionistActivity.class);
    }

}