package hu.lamsoft.hms.androidclient.adapter.impl;

import android.view.View;
import android.widget.TextView;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.adapter.ViewHolder;
import hu.lamsoft.hms.androidclient.restapi.food.dto.FoodDTO;
import hu.lamsoft.hms.androidclient.restapi.nutritionist.dto.BlogEntryDTO;

/**
 * Created by admin on 2017. 04. 15..
 */

public class BlogEntryViewHolder extends ViewHolder<BlogEntryDTO> {

    private TextView blogEntryTitle;

    public BlogEntryViewHolder(View view) {
        super(view);
        blogEntryTitle = (TextView) view.findViewById(R.id.blog_entry_title_text_view);
    }

    @Override
    public void setValues(BlogEntryDTO object) {
        blogEntryTitle.setText(object.getTitle());
    }

}
