package hu.lamsoft.hms.androidclient.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;

import hu.lamsoft.hms.androidclient.adapter.PageableDTOAdapter;
import hu.lamsoft.hms.androidclient.adapter.ViewHolder;
import hu.lamsoft.hms.androidclient.restapi.common.async.AsyncCallback;
import hu.lamsoft.hms.androidclient.restapi.common.async.DTOPagerAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.common.dto.BaseDTO;
import hu.lamsoft.hms.androidclient.restapi.common.dto.Page;

/**
 * Created by admin on 2017. 04. 15..
 */

public abstract class DTOListFragment<T extends BaseDTO, K extends ViewHolder<T>, L extends DTOPagerAsyncTask> extends Fragment {

    private int page = 0;
    private boolean hasMore = true;
    private Class<K> viewHolderType;
    private Class<L> asyncTaskType;
    private int fragmentLayoutResource;
    private int listViewResource;
    private int listItemResource;

    public DTOListFragment(Class<K> viewHolderType, Class<L> asyncTaskType, int fragmentLayoutResource, int listViewResource, int listItemResource) {
        this.viewHolderType = viewHolderType;
        this.asyncTaskType = asyncTaskType;
        this.fragmentLayoutResource = fragmentLayoutResource;
        this.listViewResource = listViewResource;
        this.listItemResource = listItemResource;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        page = 0;
        hasMore = true;
        return inflater.inflate(fragmentLayoutResource, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListView listView = (ListView) getActivity().findViewById(listViewResource);
        final PageableDTOAdapter adapter = new PageableDTOAdapter<T, K>(getActivity(), listItemResource, viewHolderType);
        startLoadData(adapter);
        listView.setAdapter(adapter);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                // Nothing to do here
            }
            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem + visibleItemCount > totalItemCount - 2) {
                    startLoadData(adapter);
                }
            }
        });
    }

    private synchronized void startLoadData(final PageableDTOAdapter adapter) {
        if(hasMore) {
            constructorViewHolder(page++, new AsyncCallback<Page<T>>() {
                @Override
                public void onPostExecute(Page<T> dtoPage) {
                    adapter.add(dtoPage.getContent());
                    adapter.notifyDataSetChanged();
                    hasMore |= !dtoPage.getLast();
                }
            }).execute();
        }
    }

    private L constructorViewHolder(int page, AsyncCallback<Page<T>> callback) {
        try {
            return asyncTaskType.getConstructor(int.class, AsyncCallback.class).newInstance(page, callback);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}