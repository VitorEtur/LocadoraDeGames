package com.br.hustlei.agendex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.br.hustlei.agendex.cliente.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, new MainFragment()).commit();
        }
    }
}