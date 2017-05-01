package hu.lamsoft.hms.androidclient.restapi.nutritionist.async;

import org.springframework.core.ParameterizedTypeReference;

import hu.lamsoft.hms.androidclient.restapi.common.async.AsyncCallback;
import hu.lamsoft.hms.androidclient.restapi.common.async.DTOPagerAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.common.dto.Page;
import hu.lamsoft.hms.androidclient.restapi.food.dto.FoodDTO;
import hu.lamsoft.hms.androidclient.restapi.nutritionist.dto.BlogEntryDTO;

/**
 * Created by admin on 2017. 04. 13..
 */

public class BlogEntriesAsyncTask extends DTOPagerAsyncTask<BlogEntryDTO> {

    public BlogEntriesAsyncTask(AsyncCallback<Page<BlogEntryDTO>> callback) {
        super(callback);
    }

    public BlogEntriesAsyncTask(int page, AsyncCallback<Page<BlogEntryDTO>> callback) {
        super(page, callback);
    }

    public BlogEntriesAsyncTask(int page, int size, AsyncCallback<Page<BlogEntryDTO>> callback) {
        super(page, size, callback);
    }

    @Override
    protected String getPath() {
        return "/nutritionist/blog-entries";
    }

    @Override
    protected ParameterizedTypeReference<Page<BlogEntryDTO>> getParameterizedTypeReference() {
        return new ParameterizedTypeReference<Page<BlogEntryDTO>>(){};
    }

}
