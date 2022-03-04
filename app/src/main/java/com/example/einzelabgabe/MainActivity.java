package com.example.einzelabgabe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button btAbschicken;
    private Button btBerechne4;
    private EditText txtEditMatrikelnummer;
    private TextView answer;
    private TextView heading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btAbschicken = findViewById(R.id.button_send);
        btBerechne4 = findViewById(R.id.button_calculate);
        txtEditMatrikelnummer = findViewById(R.id.editMatrikelnummer);
        answer = findViewById(R.id.answerServer);
        heading = findViewById(R.id.heading2);

        btAbschicken.setOnClickListener(view -> {
            heading.setText(getString(R.string.heading2));
            answer.setText("");
            String matrikelnummer = txtEditMatrikelnummer.getText().toString();
            ThreadServer askServer = new ThreadServer(matrikelnummer, answer);
            new Thread(askServer).start();
            //txtEditMatrikelnummer.setText("");
        });

        btBerechne4.setOnClickListener(view -> {
            heading.setText(getString(R.string.heading3));
            answer.setText("");
            String matrikelnummer = txtEditMatrikelnummer.getText().toString();
            int quersumme = 0;
            for(char c : matrikelnummer.toCharArray()) {
                quersumme += Integer.parseInt(String.valueOf(c));
            }
            answer.setText(Integer.toBinaryString(quersumme));
            //Log.i("Quersumme",Integer.toString(quersumme));
        });
    }
}

//Meine Matrikelnummer: 51813675 % 7 = 4 --> Quersumme	der	Matrikelnummer	bilden	und
//anschließend	als	Binärzahl	darstellen