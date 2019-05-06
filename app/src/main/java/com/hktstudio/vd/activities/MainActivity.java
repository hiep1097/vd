package com.hktstudio.vd.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.hktstudio.vd.R;
import com.hktstudio.vd.util.SharedPrefsUtils;

public class MainActivity extends AppCompatActivity {
    EditText mUsername, mPassword;
    Button mLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUsername = findViewById(R.id.edt_name);
        mPassword = findViewById(R.id.edt_pass);
        mLogin = findViewById(R.id.btn_login);
        //check if user != null
        try {
            if (!SharedPrefsUtils.getStringPreference(this,"username").isEmpty()){
                goToUser();
            }
        } catch (Exception e){

        }

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPrefsUtils.setStringPreference(MainActivity.this,"username",mUsername.getText().toString());
                SharedPrefsUtils.setStringPreference(MainActivity.this,"password",mPassword.getText().toString());
                goToUser();
            }
        });
    }
    public void goToUser(){
        Intent intent = new Intent(MainActivity.this,UserActivity.class);
        startActivity(intent);
    }
}