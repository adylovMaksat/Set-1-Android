package com.example.lab1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IntroduceActivity extends AppCompatActivity {
    // Name: Maksatbek Adylov
    // Student ID: 56422
    // Lab: 2

    EditText inputName;
    Button buttonWitaj;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_introduce);

        // Edge-to-edge padding (keep this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Connect UI elements
        inputName = findViewById(R.id.inputName);
        buttonWitaj = findViewById(R.id.buttonWitaj);
        resultText = findViewById(R.id.resultText);

        // Button click logic
        buttonWitaj.setOnClickListener(v -> {
            String name = inputName.getText().toString().trim();

            if (!name.isEmpty()) {
                resultText.setText("Witaj " + name);
            } else {
                resultText.setText("Przedstaw się.");
            }
        });
    }
}