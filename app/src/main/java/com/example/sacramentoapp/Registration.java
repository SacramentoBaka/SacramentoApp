package com.example.sacramentoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sacramentoapp.databinding.ActivityRegistrationBinding;

public class Registration extends AppCompatActivity {

    private ActivityRegistrationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registration);

        binding.registerButton.setOnClickListener(v -> {
            Intent intent = new Intent(Registration.this, MainActivity.class);
            intent.putExtra("FullName", binding.registerEmail.getText().toString().trim());
            intent.putExtra("Surname", binding.registerPassword.getText().toString().trim());

            if (binding.registerEmail.getText().toString().trim().isEmpty()
                    && binding.registerPassword.getText().toString().trim().isEmpty()) {

                Toast.makeText(this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
            } else if (binding.registerEmail.getText().toString().trim().isEmpty()){

                Toast.makeText(this, "enter email address", Toast.LENGTH_SHORT).show();
            } else if (binding.registerPassword.getText().toString().trim().isEmpty()) {

                Toast.makeText(this, "enter password", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Signing...", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });

        binding.logWindowButton.setOnClickListener(v -> {

            Intent intent = new Intent(Registration.this, Authentication.class);
            startActivity(intent);
            finish();
        });
    }
}



