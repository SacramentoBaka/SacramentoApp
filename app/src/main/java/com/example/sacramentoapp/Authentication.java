package com.example.sacramentoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sacramentoapp.databinding.ActivityAuthenticationBinding;

public class Authentication extends AppCompatActivity {

    private ActivityAuthenticationBinding binding;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_authentication);

        intent = getIntent();

        binding.logInButton.setOnClickListener(v -> {

            // Instantiating the Intent object
            intent = new Intent(Authentication.this, MainActivity.class);
            intent.putExtra("FullName", binding.authenEmail.getText().toString().trim());// Initializing the authenEmail View
            intent.putExtra("Surname", binding.logInPassword.getText().toString().trim());

            // Verifying inputs for Signing In
            if (binding.authenEmail.getText().toString().trim().isEmpty() && binding.logInPassword.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "empty input", Toast.LENGTH_SHORT).show();
            } else if (binding.authenEmail.getText().toString().trim().isEmpty()){
                Toast.makeText(this, "enter correct e-mail", Toast.LENGTH_SHORT).show();
            } else if (binding.logInPassword.getText().toString().trim().isEmpty()) {
                Toast.makeText(this, "enter correct password", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Signing...", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}