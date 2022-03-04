package com.example.einzelabgabe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button btAbschicken;
    private EditText txtEditMatrikelnummer;
    private TextView answer;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btAbschicken = findViewById(R.id.send);
        txtEditMatrikelnummer = findViewById(R.id.editMatrikelnummer);
        answer = findViewById(R.id.answerServer);
        output = findViewById(R.id.output);

        btAbschicken.setOnClickListener(view -> {
            //Meine Matrikelnummer: 51813675
            String matrikelnummer = txtEditMatrikelnummer.getText().toString();
            ThreadServer askServer = new ThreadServer(matrikelnummer, answer);
            new Thread(askServer).start();

            txtEditMatrikelnummer.setText("");

            int quersumme = 0;
            for(char c : matrikelnummer.toCharArray()) {
                quersumme += Integer.parseInt(String.valueOf(c));
            }
            output.setText(Integer.toBinaryString(quersumme));
            //Log.i("Quersumme",Integer.toString(quersumme));
        });
    }
}

//Meine Matrikelnummer: 51813675 % 7 = 4 --> Quersumme	der	Matrikelnummer	bilden	und
//anschließend	als	Binärzahl	darstellen