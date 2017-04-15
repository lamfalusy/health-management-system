package hu.lamsoft.hms.androidclient.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.LinkedList;
import java.util.List;

import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;

/**
 * Created by admin on 2017. 04. 15..
 */

public class PageableDTOAdapter<T extends BaseDTO, K extends ViewHolder<T>> extends BaseAdapter {

    private List<T> list = new LinkedList<>();
    private Activity activity;
    private int resource;
    private Class<K> viewHolderType;

    public PageableDTOAdapter(Activity activity, int resource, Class<K> viewHolderType) {
        this.activity = activity;
        this.resource = resource;
        this.viewHolderType = viewHolderType;
    }

    public void add(List<T> list){
        this.list.addAll(list);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public T getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        K viewHolder;
        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(activity);
            convertView = layoutInflater.inflate(resource, parent, false);
            viewHolder = constructorViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (K) convertView.getTag();
        }

        viewHolder.setValues(getItem(position));

        return convertView;
    }

    private K constructorViewHolder(View convertView) {
        try {
            return viewHolderType.getConstructor(View.class).newInstance(convertView);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
