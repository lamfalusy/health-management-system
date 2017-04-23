package hu.lamsoft.hms.androidclient.activity;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.fragment.DTOListFragment;
import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;

/**
 * Created by admin on 2017. 04. 23..
 */

public class DTODetailsActivity<T extends BaseDTO> extends NavigationActivity {

    protected T baseDTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseDTO = (T) getIntent().getExtras().get(DTOListFragment.DTO_EXTRAS);
    }

}
