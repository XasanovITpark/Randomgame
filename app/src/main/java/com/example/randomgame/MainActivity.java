package com.example.randomgame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber;
    TextView textViewMessage;
    Button buttonCheck, buttonRestart;
    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // XML elementlarni ulash
        editTextNumber = findViewById(R.id.editTextNumber);
        textViewMessage = findViewById(R.id.textViewMessage);
        buttonCheck = findViewById(R.id.buttonCheck);
        buttonRestart = findViewById(R.id.buttonRestart);

        // Dastlab random son yaratish
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1; // 1–100 gacha

        // "Sonni kiritib bosing" tugmasi
        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = editTextNumber.getText().toString();

                if (userInput.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Siz hali son kiritmadingiz!", Toast.LENGTH_SHORT).show();
                } else {
                    int userNumber = Integer.parseInt(userInput);

                    if (userNumber < randomNumber) {
                        textViewMessage.setText("Siz kiritgan son kichik; Katta son kiriting");
                    } else if (userNumber > randomNumber) {
                        textViewMessage.setText("Siz kiritgan son katta; Kichik son kiriting");
                    } else {
                        textViewMessage.setText("🎉 To‘g‘ri topdingiz! 🎉");
                    }
                }
            }
        });

        // "Qayta boshlash" tugmasi
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomNumber = random.nextInt(100) + 1;
                editTextNumber.setText("");
                textViewMessage.setText("O‘yin qayta boshlandi!");
                Toast.makeText(MainActivity.this, "O‘yin qayta boshlandi!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
