package com.example.einzelabgabe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.net.*;

public class MainActivity extends AppCompatActivity {

    private Button btAbschicken;
    private EditText txtEditMatrikelnummer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btAbschicken = findViewById(R.id.send);
        txtEditMatrikelnummer = findViewById(R.id.editMatrikelnummer);

        btAbschicken.setOnClickListener(view -> txtEditMatrikelnummer.setText("Test"));


    }
}