package hu.lamsoft.hms.androidclient.activity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.restapi.food.dto.RecipeComponentDTO;
import hu.lamsoft.hms.androidclient.restapi.food.dto.RecipeDTO;

public class RecipeActivity extends DTODetailsActivity<RecipeDTO> {

    private TextView storyTextView;
    private TextView descriptionTextView;
    private ListView componentsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        getSupportActionBar().setTitle(baseDTO.getName());

        storyTextView = (TextView) findViewById(R.id.recipe_activity_story_text_view);
        descriptionTextView = (TextView) findViewById(R.id.recipe_activity_description_text_view);
        componentsListView = (ListView) findViewById(R.id.recipe_activity_components_list_view);

        storyTextView.setText(baseDTO.getStory());
        descriptionTextView.setText(baseDTO.getDescription());
        componentsListView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return baseDTO.getComponents().size();
            }

            @Override
            public RecipeComponentDTO getItem(int position) {
                return baseDTO.getComponents().get(position);
            }

            @Override
            public long getItemId(int position) {
                return baseDTO.getComponents().get(position).getId();
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(convertView == null){
                    LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                    convertView = layoutInflater.inflate(R.layout.list_item_recipe_component, parent, false);
                }

                RecipeComponentDTO component = getItem(position);

                ((TextView) convertView.findViewById(R.id.recipe_component_name_text_view)).setText(component.getQuantity().getDoubleValue()+" "+component.getQuantity().getUnit().getShortName()+" "+component.getFood().getName());

                return convertView;
            }
        });
    }
}
