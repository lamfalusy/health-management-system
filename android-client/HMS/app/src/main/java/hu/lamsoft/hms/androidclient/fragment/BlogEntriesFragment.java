package hu.lamsoft.hms.androidclient.fragment;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.activity.BlogEntryActivity;
import hu.lamsoft.hms.androidclient.adapter.impl.BlogEntryViewHolder;
import hu.lamsoft.hms.androidclient.restapi.nutritionist.async.BlogEntriesAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.nutritionist.dto.BlogEntryDTO;

public class BlogEntriesFragment extends DTOListFragment<BlogEntryDTO, BlogEntryViewHolder, BlogEntriesAsyncTask> {

    public BlogEntriesFragment() {
        super(BlogEntryViewHolder.class, BlogEntriesAsyncTask.class, R.layout.fragment_blog_entries, R.id.blog_entries_list_view, R.layout.list_item_blog_entry, BlogEntryActivity.class);
    }

}