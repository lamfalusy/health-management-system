package hu.lamsoft.hms.androidclient.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import hu.lamsoft.hms.androidclient.R;
import hu.lamsoft.hms.androidclient.component.session.Session;
import hu.lamsoft.hms.androidclient.restapi.common.async.AsyncCallback;
import hu.lamsoft.hms.androidclient.restapi.customer.async.CustomerAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.customer.async.LoginAsyncTask;
import hu.lamsoft.hms.androidclient.restapi.customer.dto.CustomerDTO;
import hu.lamsoft.hms.androidclient.restapi.customer.vo.LogedInCustomerVO;
import hu.lamsoft.hms.androidclient.restapi.customer.vo.LoginVO;

public class LoginActivity extends NavigationActivity implements View.OnClickListener {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");

        emailEditText = (EditText) findViewById(R.id.login_activity_email_edit_text);
        passwordEditText = (EditText) findViewById(R.id.login_activity_password_edit_text);
        loginButton = (Button) findViewById(R.id.login_activity_login_button);

        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        Log.i("LoginActivity", email+" "+password);
        if(email != null && password != null) {
            LoginVO loginVO = new LoginVO();
            loginVO.setUsername(email);
            loginVO.setPassword(password);
            new LoginAsyncTask(loginVO, new AsyncCallback<LogedInCustomerVO>() {
                @Override
                public void onPostExecute(LogedInCustomerVO logedInCustomerVO) {
                    if(logedInCustomerVO != null) {
                        Session.instance.getAuthenticationManager().login(logedInCustomerVO);
                        Log.i("LoginActivity", Session.instance.getAuthenticationManager().getToken());
                        new CustomerAsyncTask(new AsyncCallback<CustomerDTO>() {
                            @Override
                            public void onPostExecute(CustomerDTO customerDTO) {
                                Log.i("LoginActivity", customerDTO.toString());
                                Session.instance.getAuthenticationManager().setCustomer(customerDTO);
                                finish();
                            }
                        }).execute();
                        showToast("Login was successful.");
                    } else {
                        showToast("Email and password are incorrect.");
                    }
                }
            }).execute();
        } else {
            showToast("Email and password fields are mandatory.");
        }
    }

    private void showToast(String message) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }
}
