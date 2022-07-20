package com.br.hustlei.agendex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.br.hustlei.agendex.cliente.MainFragment;
//***Importando recursos da biblioteca do Android Studio

public class MainActivity extends AppCompatActivity { //***Classe Main Activity

    @Override //***Sobrescrita de método
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, new MainFragment()).commit();
        }
    }
}