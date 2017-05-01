package hu.lamsoft.hms.androidclient.fragment;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.activity.RecipeActivity;
import hu.lamsoft.hms.androidclient.adapter.impl.RecipeViewHolder;
import hu.lamsoft.hms.androidclient.restapi.food.async.RecipesAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.food.dto.RecipeDTO;

public class RecipesFragment extends DTOListFragment<RecipeDTO, RecipeViewHolder, RecipesAsyncTask> {

    public RecipesFragment() {
        super(RecipeViewHolder.class, RecipesAsyncTask.class, R.layout.fragment_recipes, R.id.recipes_list_view, R.layout.list_item_recipe, RecipeActivity.class);
    }

}