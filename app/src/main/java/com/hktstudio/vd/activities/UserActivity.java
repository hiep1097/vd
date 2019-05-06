package com.hktstudio.vd.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hktstudio.vd.R;
import com.hktstudio.vd.util.SharedPrefsUtils;

public class UserActivity extends AppCompatActivity {
    TextView mUserName, mPassword;
    Button mLogout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        mUserName = findViewById(R.id.tv_username);
        mPassword = findViewById(R.id.tv_password);
        mLogout = findViewById(R.id.btn_logout);
        mUserName.setText("Username: "+SharedPrefsUtils.getStringPreference(this,"username"));
        mPassword.setText("Password: "+SharedPrefsUtils.getStringPreference(this,"password"));
        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPrefsUtils.setStringPreference(UserActivity.this,"username","");
                SharedPrefsUtils.setStringPreference(UserActivity.this,"password","");
                finish();
            }
        });
    }
}
