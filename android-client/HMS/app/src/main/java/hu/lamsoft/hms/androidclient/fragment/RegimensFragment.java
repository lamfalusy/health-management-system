package hu.lamsoft.hms.androidclient.fragment;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.activity.RegimenActivity;
import hu.lamsoft.hms.androidclient.adapter.impl.RegimenViewHolder;
import hu.lamsoft.hms.androidclient.restapi.regimen.async.RegimensAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.regimen.dto.RegimenDTO;

public class RegimensFragment extends DTOListFragment<RegimenDTO, RegimenViewHolder, RegimensAsyncTask> {

    public RegimensFragment() {
        super(RegimenViewHolder.class, RegimensAsyncTask.class, R.layout.fragment_regimens, R.id.regimens_list_view, R.layout.list_item_regimen, RegimenActivity.class);
    }

}