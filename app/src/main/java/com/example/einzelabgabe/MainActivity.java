package com.example.einzelabgabe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button btAbschicken;
    private EditText txtEditMatrikelnummer;
    private TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btAbschicken = findViewById(R.id.send);
        txtEditMatrikelnummer = findViewById(R.id.editMatrikelnummer);
        answer = findViewById(R.id.answerServer);

        btAbschicken.setOnClickListener(view -> {
            //Meine Matrikelnummer: 51813675
            ThreadServer askServer = new ThreadServer(txtEditMatrikelnummer.getText().toString(), answer);
            new Thread(askServer).start();
            txtEditMatrikelnummer.setText("");
        });


    }
}