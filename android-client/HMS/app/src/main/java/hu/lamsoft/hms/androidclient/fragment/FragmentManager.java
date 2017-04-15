package hu.lamsoft.hms.androidclient.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import java.util.HashMap;
import java.util.Map;

import hu.lamsoft.hms.androidclient.R;

/**
 * Created by admin on 2017. 04. 14..
 */

public class FragmentManager {

    public static FragmentManager instance;

    static {
        Map<Class<? extends Fragment>, Fragment> fragmentMap = new HashMap<>();
        fragmentMap.put(FoodsFragment.class, new FoodsFragment());
        fragmentMap.put(RecipesFragment.class, new RecipesFragment());
        fragmentMap.put(NutritionistsFragment.class, new NutritionistsFragment());
        fragmentMap.put(BlogEntriesFragment.class, new BlogEntriesFragment());
        fragmentMap.put(RegimensFragment.class, new RegimensFragment());
        instance = new FragmentManager(fragmentMap);
    }

    private Map<Class<? extends Fragment>, Fragment> fragmentMap;

    private FragmentManager(Map<Class<? extends Fragment>, Fragment> fragmentMap) {
        this.fragmentMap = fragmentMap;
    }

    public <T extends Fragment> void addFragment(Class<T> type, FragmentTransaction transaction) {
        transaction.replace(R.id.fragment_container, fragmentMap.get(type));
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
