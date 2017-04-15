package hu.lamsoft.hms.androidclient.restapi.food.async;

import org.springframework.core.ParameterizedTypeReference;

import hu.lamsoft.hms.androidclient.restapi.common.async.AsyncCallback;
import hu.lamsoft.hms.androidclient.restapi.common.async.DTOPagerAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.common.dto.Page;
import hu.lamsoft.hms.androidclient.restapi.food.dto.FoodDTO;
import hu.lamsoft.hms.androidclient.restapi.food.dto.RecipeDTO;

/**
 * Created by admin on 2017. 04. 13..
 */

public class RecipesAsyncTask extends DTOPagerAsyncTask<RecipeDTO> {

    public RecipesAsyncTask(AsyncCallback<Page<RecipeDTO>> callback) {
        super(callback);
    }

    public RecipesAsyncTask(int page, AsyncCallback<Page<RecipeDTO>> callback) {
        super(page, callback);
    }

    public RecipesAsyncTask(int page, int size, AsyncCallback<Page<RecipeDTO>> callback) {
        super(page, size, callback);
    }

    @Override
    protected String getPath() {
        return "/food/recipes";
    }

    @Override
    protected ParameterizedTypeReference<Page<RecipeDTO>> getParameterizedTypeReference() {
        return new ParameterizedTypeReference<Page<RecipeDTO>>(){};
    }

}
