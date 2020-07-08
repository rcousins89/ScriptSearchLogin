package com.example.loginvolley;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AppStartActivity extends AppCompatActivity {

    Button logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_start);

        final SharedPreferences sharedPreferences = getSharedPreferences("UserInfo",MODE_PRIVATE);

        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(getResources().getString(R.string.prefLoginState),"loggedout");
                editor.apply();
                startActivity(new Intent(AppStartActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}
