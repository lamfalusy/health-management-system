package hu.lamsoft.hms.androidclient.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.activity.BlogEntryActivity;
import hu.lamsoft.hms.androidclient.adapter.impl.BlogEntryViewHolder;
import hu.lamsoft.hms.androidclient.adapter.impl.FoodViewHolder;
import hu.lamsoft.hms.androidclient.restapi.food.async.BlogEntriesAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.food.async.FoodsAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.food.dto.FoodDTO;
import hu.lamsoft.hms.androidclient.restapi.nutritionist.dto.BlogEntryDTO;

public class BlogEntriesFragment extends DTOListFragment<BlogEntryDTO, BlogEntryViewHolder, BlogEntriesAsyncTask> {

    public BlogEntriesFragment() {
        super(BlogEntryViewHolder.class, BlogEntriesAsyncTask.class, R.layout.fragment_blog_entries, R.id.blog_entries_list_view, R.layout.list_item_blog_entry, BlogEntryActivity.class);
    }

}