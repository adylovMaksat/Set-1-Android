package com.example.lab1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GuessGameActivity extends AppCompatActivity {

    // Name: Maksatbek Adylov
    // Student ID: 56422
    // Lab: 3

    EditText inputNumber;
    Button buttonGuess;
    TextView textResult;

    int randomNumber;
    int attempts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_guess_game);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputNumber = findViewById(R.id.inputNumber);
        buttonGuess = findViewById(R.id.buttonGuess);
        textResult = findViewById(R.id.textResult);

        startNewGame();

        buttonGuess.setOnClickListener(v -> handleGuess());
    }

    private void startNewGame() {
        Random random = new Random();
        randomNumber = random.nextInt(10) + 1; // 1..10
        attempts = 0;
    }

    private void handleGuess() {
        String input = inputNumber.getText().toString().trim();

        // ❗ Validation
        if (input.isEmpty()) {
            textResult.setText("Please enter an integer number.");
            return;
        }

        int guess;
        try {
            guess = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            textResult.setText("Please enter an integer number.");
            return;
        }

        if (guess < 1 || guess > 10) {
            textResult.setText("Number must be in range 1..10.");
            return;
        }

        attempts++;

        if (guess < randomNumber) {
            textResult.setText("Value too small");
        } else if (guess > randomNumber) {
            textResult.setText("Value too large");
        } else {
            // ✅ Correct guess logic
            if (attempts == 2) {
                textResult.setText("Correct — achieved on the 2nd attempt");
            } else {
                textResult.setText("Correct, but not on the 2nd attempt. Try again.");
                startNewGame();
            }
        }
    }
}