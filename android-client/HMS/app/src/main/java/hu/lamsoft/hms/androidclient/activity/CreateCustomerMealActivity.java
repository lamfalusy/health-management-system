package hu.lamsoft.hms.androidclient.activity;

import android.os.Bundle;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.restapi.food.dto.FoodDTO;

public class CreateCustomerMealActivity extends NavigationActivity {

    private FoodDTO foodDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_customer_meal);
        foodDTO = (FoodDTO) getIntent().getExtras().get(FoodActivity.DTO_EXTRAS);
        getSupportActionBar().setTitle("Create meal: "+foodDTO.getName());
    }
}
