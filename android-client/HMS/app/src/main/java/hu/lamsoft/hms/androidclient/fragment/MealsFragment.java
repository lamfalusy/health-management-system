package hu.lamsoft.hms.androidclient.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.adapter.PageableDTOAdapter;
import hu.lamsoft.hms.androidclient.adapter.impl.MealViewHolder;
import hu.lamsoft.hms.androidclient.restapi.common.async.AsyncCallback;
import hu.lamsoft.hms.androidclient.restapi.customer.async.CustomerMealsAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.customer.dto.CustomerMealDTO;

public class MealsFragment extends Fragment {

    private DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
    private PageableDTOAdapter<CustomerMealDTO, MealViewHolder> adapter;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_meals, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new PageableDTOAdapter<>(getActivity(), R.layout.list_item_meal, MealViewHolder.class);
        listView = (ListView) getActivity().findViewById(R.id.meals_list_view);
        listView.setAdapter(adapter);
        new CustomerMealsAsyncTask(getDate("2016.01.01"), getDate("2018.01.01"), new AsyncCallback<List<CustomerMealDTO>>() {
            @Override
            public void onPostExecute(List<CustomerMealDTO> customerMealDTOs) {
                adapter.add(customerMealDTOs);
                adapter.notifyDataSetChanged();
            }
        }).execute();
    }

    private Date getDate(String dateString) {
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            return null;
        }
    }

}
