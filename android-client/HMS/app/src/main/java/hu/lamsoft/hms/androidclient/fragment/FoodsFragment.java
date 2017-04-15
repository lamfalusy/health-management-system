package hu.lamsoft.hms.androidclient.fragment;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.adapter.impl.FoodViewHolder;
import hu.lamsoft.hms.androidclient.restapi.food.async.FoodsAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.food.dto.FoodDTO;

public class FoodsFragment extends DTOListFragment<FoodDTO, FoodViewHolder, FoodsAsyncTask> {

    public FoodsFragment() {
        super(FoodViewHolder.class, FoodsAsyncTask.class, R.layout.fragment_foods, R.id.foods_list_view, R.layout.list_item_food);
    }

}
