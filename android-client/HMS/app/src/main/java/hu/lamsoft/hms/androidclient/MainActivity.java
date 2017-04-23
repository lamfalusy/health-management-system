package hu.lamsoft.hms.androidclient;

import android.content.Intent;
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

import java.util.Date;

import hu.lamsoft.hms.androidclient.activity.LoginActivity;
import hu.lamsoft.hms.androidclient.activity.NavigationActivity;
import hu.lamsoft.hms.androidclient.activity.RegisterActivity;
import hu.lamsoft.hms.androidclient.component.session.Session;
import hu.lamsoft.hms.androidclient.fragment.BlogEntriesFragment;
import hu.lamsoft.hms.androidclient.fragment.FragmentManager;
import hu.lamsoft.hms.androidclient.fragment.NutritionistsFragment;
import hu.lamsoft.hms.androidclient.fragment.RegimensFragment;
import hu.lamsoft.hms.androidclient.restapi.DisableSSLCertificateCheckUtil;
import hu.lamsoft.hms.androidclient.fragment.FoodsFragment;
import hu.lamsoft.hms.androidclient.fragment.RecipesFragment;
import hu.lamsoft.hms.androidclient.restapi.common.async.AsyncCallback;
import hu.lamsoft.hms.androidclient.restapi.customer.async.CustomerAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.customer.async.LoginAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.customer.async.RegistrationAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.customer.dto.CustomerDTO;
import hu.lamsoft.hms.androidclient.restapi.customer.vo.CustomerRegistrationVO;
import hu.lamsoft.hms.androidclient.restapi.customer.vo.LogedInCustomerVO;
import hu.lamsoft.hms.androidclient.restapi.customer.vo.LoginVO;

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
            addFragment(FoodsFragment.class);
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

        // haha
//        CustomerRegistrationVO regVO = new CustomerRegistrationVO();
//        regVO.setEmail("android@test.and");
//        regVO.setBirthday(new Date());
//        regVO.setRawPassword("password");
//        new RegistrationAsyncTask(regVO, new AsyncCallback<CustomerDTO>() {
//            @Override
//            public void onPostExecute(CustomerDTO customerDTO) {
//                LoginVO loginVO = new LoginVO();
//                loginVO.setUsername("android@test.and");
//                loginVO.setPassword("password");
//                new LoginAsyncTask(loginVO, new AsyncCallback<LogedInCustomerVO>(){
//                    @Override
//                    public void onPostExecute(LogedInCustomerVO logedInCustomerVO) {
//                        Session.instance.getAuthenticationManager().login(logedInCustomerVO);
//                        Log.i("MainActivity", Session.instance.getAuthenticationManager().getToken());
//                        new CustomerAsyncTask(new AsyncCallback<CustomerDTO>() {
//                            @Override
//                            public void onPostExecute(CustomerDTO customerDTO) {
//                                Log.i("MainActivity", customerDTO.toString());
//                            }
//                        }).execute();
//                    }
//                }).execute();
//            }
//        }).execute();



        int id = item.getItemId();
        if (id == R.id.nav_login) {
            addActivity(LoginActivity.class);
        } else if (id == R.id.nav_register) {
            addActivity(RegisterActivity.class);
        } else if (id == R.id.nav_foods) {
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

    private <T extends NavigationActivity> void addActivity(Class<T> type) {
        startActivity(new Intent(this, type));
    }

}
