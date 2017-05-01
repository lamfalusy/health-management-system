package hu.lamsoft.hms.androidclient.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.restapi.nutritionist.dto.NutritionistDTO;

public class NutritionistActivity extends DTODetailsActivity<NutritionistDTO> {

    private TextView emailTextView;
    private TextView introductionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutritionist);
        getSupportActionBar().setTitle(baseDTO.getCustomer().getFirstname()+" "+baseDTO.getCustomer().getLastname());

        emailTextView = (TextView) findViewById(R.id.nutritionist_activity_email_text_view);
        introductionTextView = (TextView) findViewById(R.id.nutritionist_activity_introduction_text_view);

        emailTextView.setText(baseDTO.getCustomer().getEmail());
        introductionTextView.setText(baseDTO.getIntroduction());
    }
}
