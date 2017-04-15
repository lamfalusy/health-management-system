package hu.lamsoft.hms.androidclient;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import hu.lamsoft.hms.androidclient.fragment.BlogEntriesFragment;
import hu.lamsoft.hms.androidclient.fragment.FragmentManager;
import hu.lamsoft.hms.androidclient.fragment.NutritionistsFragment;
import hu.lamsoft.hms.androidclient.fragment.RegimensFragment;
import hu.lamsoft.hms.androidclient.restapi.DisableSSLCertificateCheckUtil;
import hu.lamsoft.hms.androidclient.fragment.FoodsFragment;
import hu.lamsoft.hms.androidclient.fragment.RecipesFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        try {
            DisableSSLCertificateCheckUtil.disableChecks();
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            addFragment(RecipesFragment.class);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_foods) {
            addFragment(FoodsFragment.class);
        } else if (id == R.id.nav_recipes) {
            addFragment(RecipesFragment.class);
        } else if (id == R.id.nav_nutritionists) {
            addFragment(NutritionistsFragment.class);
        } else if (id == R.id.nav_blog_entries) {
            addFragment(BlogEntriesFragment.class);
        } else if (id == R.id.nav_regimens) {
            addFragment(RegimensFragment.class);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private <T extends Fragment> void addFragment(Class<T> type) {
        FragmentManager.instance.addFragment(type, getSupportFragmentManager().beginTransaction());
    }

}
