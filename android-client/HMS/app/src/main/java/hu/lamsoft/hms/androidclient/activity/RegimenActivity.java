package hu.lamsoft.hms.androidclient.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.component.session.Session;
import hu.lamsoft.hms.androidclient.restapi.regimen.dto.RegimenDTO;

public class RegimenActivity extends DTODetailsActivity<RegimenDTO> {

    private TextView writerTextView;
    private TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regimen);
        getSupportActionBar().setTitle(baseDTO.getName());

        writerTextView = (TextView) findViewById(R.id.regimen_activity_writer_text_view);
        descriptionTextView = (TextView) findViewById(R.id.regimen_activity_description_text_view);

        writerTextView.setText(baseDTO.getCreator().getCustomer().getFirstname()+" "+baseDTO.getCreator().getCustomer().getLastname());
        descriptionTextView.setText(baseDTO.getDescription());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(Session.instance.getAuthenticationManager().customerLogedIn()) {
            MenuItem item = menu.add(0, 0, 0, "Like").setIcon(R.drawable.ic_menu_logo);
            item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    Context context = getApplicationContext();
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, "Regimen has assigned to customer.", duration);
                    toast.show();
                    return true;
                }
            });
        }
        return true;
    }

}
