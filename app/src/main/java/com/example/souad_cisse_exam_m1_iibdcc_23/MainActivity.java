package com.example.souad_cisse_exam_m1_iibdcc_23;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button loginButton;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.loginButton);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        loginButton.setOnClickListener(view -> login());
    }

    private void login() {
        storeUserData();

        Intent intent = new Intent(this, IPInfoActivity.class);
        startActivity(intent);
    }

    private void storeUserData() {
        SharedPreferences sharedPreferences = getSharedPreferences("IPAppPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("username", username.getText().toString());
        editor.putString("password", password.getText().toString());

        editor.apply();
    }
}