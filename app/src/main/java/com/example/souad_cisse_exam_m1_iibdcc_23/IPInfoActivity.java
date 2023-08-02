package com.example.souad_cisse_exam_m1_iibdcc_23;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.souad_cisse_exam_m1_iibdcc_23.souad_cisse_model.IPResponseModel;
import com.example.souad_cisse_exam_m1_iibdcc_23.souad_cisse_network.IPRetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IPInfoActivity extends AppCompatActivity {

    Button showButton;
    EditText searchField;
    TextView city;
    TextView region;
    TextView country;

    TextView userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip_info);

        showButton = findViewById(R.id.showButton);
        searchField = findViewById(R.id.searchField);
        city = findViewById(R.id.city);
        region = findViewById(R.id.region);
        country = findViewById(R.id.country);
        userInfo = findViewById(R.id.userInfo);

        getUserInfo();

        showButton.setOnClickListener(view -> {
            if (searchField.getText().length() == 0)
                Toast.makeText(this, "Please enter the ip address", Toast.LENGTH_SHORT).show();
            else
                getIpInfo(searchField.getText().toString());
        });
    }

    private void getIpInfo(String ipAddress) {
        Call<IPResponseModel> call = IPRetrofitClient.getInstance()
                .geIPApi()
                .getIPInfo(ipAddress);
        call.enqueue(new Callback<IPResponseModel>() {
            @Override
            public void onResponse(Call<IPResponseModel> call, Response<IPResponseModel> response) {
                IPResponseModel myIpInfo = response.body();

                if (response.code() == 404 || myIpInfo == null) {
                    Toast.makeText(getApplicationContext(), "Error: Wrong address", Toast.LENGTH_LONG)
                            .show();
                } else {
                    city.append(" " + myIpInfo.getCity());
                    region.append(" " + myIpInfo.getRegion());
                    country.append(" " + myIpInfo.getCountry());
                }
            }

            @Override
            public void onFailure(Call<IPResponseModel> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error:" + t.getMessage(), Toast.LENGTH_LONG)
                        .show();
            }

        });
    }

    private void getUserInfo() {
        SharedPreferences sharedPreferences = getSharedPreferences("IPAppPreferences", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");

        userInfo.append("username: " + username + " password: " + password);
    }
}