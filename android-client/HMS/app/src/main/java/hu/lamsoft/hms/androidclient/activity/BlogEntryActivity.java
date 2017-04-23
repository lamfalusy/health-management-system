package hu.lamsoft.hms.androidclient.activity;

import android.os.Bundle;
import android.widget.TextView;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.restapi.nutritionist.dto.BlogEntryDTO;

public class BlogEntryActivity extends DTODetailsActivity<BlogEntryDTO> {

    private TextView blogEntryWriter;
    private TextView blogEntryPreface;
    private TextView blogEntryContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_entry);
        getSupportActionBar().setTitle(baseDTO.getTitle());

        blogEntryWriter = (TextView) findViewById(R.id.blog_entry_activity_writer_text_view);
        blogEntryPreface = (TextView) findViewById(R.id.blog_entry_activity_preface_text_view);
        blogEntryContent = (TextView) findViewById(R.id.blog_entry_activity_content_text_view);

        blogEntryWriter.setText(baseDTO.getWriter().getCustomer().getFirstname()+" "+baseDTO.getWriter().getCustomer().getLastname());
        blogEntryPreface.setText(baseDTO.getPreface());
        blogEntryContent.setText(baseDTO.getContent());
    }

}
