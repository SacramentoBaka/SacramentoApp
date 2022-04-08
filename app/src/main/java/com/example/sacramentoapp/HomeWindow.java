package com.example.sacramentoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sacramentoapp.databinding.ActivityHomeWindowBinding;

public class HomeWindow extends AppCompatActivity {

    private ActivityHomeWindowBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_window);

        binding.homeSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeWindow.this, Registration.class);
                startActivity(intent);
                finish();
            }
        });

        binding.homeLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeWindow.this, Authentication.class);
                startActivity(intent);
                finish();
            }
        });
    }
}