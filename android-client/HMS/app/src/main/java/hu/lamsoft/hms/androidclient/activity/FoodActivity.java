package hu.lamsoft.hms.androidclient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.component.session.Session;
import hu.lamsoft.hms.androidclient.restapi.food.dto.FoodDTO;
import hu.lamsoft.hms.androidclient.restapi.unit.dto.QuantityDTO;

public class FoodActivity extends DTODetailsActivity<FoodDTO> {

    public static String DTO_EXTRAS = "dtoExtras";

    private TextView energyInKcalTextView;
    private TextView energyInKjTextView;
    private TextView waterInGTextView;
    private TextView proteinInGTextView;
    private TextView carbohydratesInGTextView;
    private TextView sugarInGTextView;
    private TextView fatInGTextView;
    private TextView saturatedFatInGTextView;
    private TextView monounsaturatedFatInGTextView;
    private TextView polyunsaturatedFatInGTextView;
    private TextView cholesterolInMgTextView;
    private TextView fiberInGTextView;
    private TextView emotionalTextView;
    private TextView healthyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        getSupportActionBar().setTitle(baseDTO.getName());

        carbohydratesInGTextView = (TextView) findViewById(R.id.food_activity_carbohydrates_in_g_text_view);
        cholesterolInMgTextView = (TextView) findViewById(R.id.food_activity_cholesterol_in_g_text_view);
        emotionalTextView = (TextView) findViewById(R.id.food_activity_emotional_text_view);
        energyInKcalTextView = (TextView) findViewById(R.id.food_activity_energy_in_kcal_text_view);
        energyInKjTextView = (TextView) findViewById(R.id.food_activity_energy_in_kj_text_view);
        fatInGTextView = (TextView) findViewById(R.id.food_activity_fat_in_g_text_view);
        healthyTextView = (TextView) findViewById(R.id.food_activity_healthy_text_view);
        fiberInGTextView = (TextView) findViewById(R.id.food_activity_fiber_in_g_text_view);
        monounsaturatedFatInGTextView = (TextView) findViewById(R.id.food_activity_monounsaturated_fat_in_g_text_view);
        polyunsaturatedFatInGTextView = (TextView) findViewById(R.id.food_activity_polyunsaturated_fat_in_g_text_view);
        proteinInGTextView = (TextView) findViewById(R.id.food_activity_protein_in_g_text_view);
        saturatedFatInGTextView = (TextView) findViewById(R.id.food_activity_satureted_fat_in_g_text_view);
        sugarInGTextView = (TextView) findViewById(R.id.food_activity_sugar_in_g_text_view);
        waterInGTextView = (TextView) findViewById(R.id.food_activity_water_in_g_text_view);

        setText(carbohydratesInGTextView, baseDTO.getCarbohydratesInG());
        setText(cholesterolInMgTextView, baseDTO.getCholesterolInMg());
        setText(emotionalTextView, baseDTO.getEmotional());
        setText(energyInKcalTextView, baseDTO.getEnergyInKcal());
        setText(energyInKjTextView, baseDTO.getEnergyInKj());
        setText(fatInGTextView, baseDTO.getFatInG());
        setText(healthyTextView, baseDTO.getHealthy());
        setText(fiberInGTextView, baseDTO.getFiberInG());
        setText(monounsaturatedFatInGTextView, baseDTO.getMonounsaturatedFatInG());
        setText(polyunsaturatedFatInGTextView, baseDTO.getPolyunsaturatedFatInG());
        setText(proteinInGTextView, baseDTO.getProteinInG());
        setText(saturatedFatInGTextView, baseDTO.getSaturatedFatInG());
        setText(sugarInGTextView, baseDTO.getSugarInG());
        setText(waterInGTextView, baseDTO.getWaterInG());
    }

    private void setText(TextView textView, QuantityDTO quantityDTO) {
        if(quantityDTO != null) {
            textView.setText(quantityDTO.getDoubleValue().toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(Session.instance.getAuthenticationManager().customerLogedIn()) {
            MenuItem item = menu.add(0, 0, 0, "Meal").setIcon(R.drawable.ic_menu_meal_white);
            item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Intent intent = new Intent(getApplicationContext(), CreateCustomerMealActivity.class);
                    intent.putExtra(DTO_EXTRAS, baseDTO);
                    startActivity(intent);
                    return true;
                }
            });
        }
        return true;
    }
}
