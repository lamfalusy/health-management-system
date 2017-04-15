package hu.lamsoft.hms.androidclient.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.adapter.impl.RegimenViewHolder;
import hu.lamsoft.hms.androidclient.restapi.food.async.RegimensAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.regimen.dto.RegimenDTO;

public class RegimensFragment extends DTOListFragment<RegimenDTO, RegimenViewHolder, RegimensAsyncTask> {

    public RegimensFragment() {
        super(RegimenViewHolder.class, RegimensAsyncTask.class, R.layout.fragment_regimens, R.id.regimens_list_view, R.layout.list_item_regimen);
    }

}