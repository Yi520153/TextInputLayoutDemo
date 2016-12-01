package com.lcl.textinputlayoutdemo;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userName;
    private TextInputLayout userNameTextInputLayout;
    private EditText password;
    private TextInputLayout passwordTextInputLayout;
    private Button login;

    private static final String DEFAULT_USER_NAME="yishuihan";
    private static final String DEFAULT_PASSWORD="lcl123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        userName = (EditText) findViewById(R.id.userName);
        userNameTextInputLayout = (TextInputLayout) findViewById(R.id.userNameTextInputLayout);
        password = (EditText) findViewById(R.id.password);
        passwordTextInputLayout = (TextInputLayout) findViewById(R.id.passwordTextInputLayout);
        login = (Button) findViewById(R.id.login);

        userNameTextInputLayout.setHint(getResources().getString(R.string.user_name_hint));

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                String userNameStr = userName.getText().toString().trim();
                String passwordStr = password.getText().toString().trim();
                if(TextUtils.isEmpty(userNameStr)){
                    userNameTextInputLayout.setError(getString(R.string.user_name_null_hint));
                    return;
                }
                if(TextUtils.isEmpty(passwordStr)){
                    passwordTextInputLayout.setError(getString(R.string.password_null_hint));
                    return;
                }
                if(!DEFAULT_USER_NAME.equals(userNameStr)){
                    userNameTextInputLayout.setError(getString(R.string.user_name_error_hint));
                    return;
                }
                if(!DEFAULT_PASSWORD.equals(passwordStr)){
                    passwordTextInputLayout.setError(getString(R.string.password_error_hint));
                    return;
                }
                userNameTextInputLayout.setErrorEnabled(false);
                passwordTextInputLayout.setErrorEnabled(false);
                doLogin();
                break;
        }
    }

    private void doLogin(){
        Snackbar.make(login, R.string.login_success_hint,Snackbar.LENGTH_SHORT).show();
    }
}
