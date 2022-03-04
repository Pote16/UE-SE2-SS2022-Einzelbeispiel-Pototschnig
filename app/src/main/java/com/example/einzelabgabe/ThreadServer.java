package com.example.einzelabgabe;

import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ThreadServer implements Runnable{
    String matrikelNummer;
    TextView answerfield;

    ThreadServer(String matrikelNummer, TextView answer){
        this.matrikelNummer = matrikelNummer;
        this.answerfield = answer;
    }


    @Override
    public void run() {
        try {
            Socket clientSocket = new Socket("se2-isys.aau.at",53212);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Log.i("Test",matrikelNummer);
            outToServer.writeBytes(matrikelNummer +'\n');
            this.answerfield.setText(inFromServer.readLine());


            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
