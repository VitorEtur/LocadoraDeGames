package com.br.hustlei.agendex.cliente;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.br.hustlei.agendex.R;

public class MainFragment extends Fragment { //***Fragmento Main

    public MainFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, /*Inflar menu*/
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.cliente_fragment_main, container, false);

        if (savedInstanceState == null) {    /*Método if para se o aplicativo n tiver nada aparecendo na tela puxar um fragment*/
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_cliente, new ListarFragment()).commit();
        }

        Button btnAdicionar = v.findViewById(R.id.button_adicionar_cliente); /*Evento para navegar entre telas ao clicar no botão*/
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_cliente, new AdicionarFragment()).commit();
            }
        });



        Button btnListar = v.findViewById(R.id.button_listar_cliente); /*Evento para navegar entre telas ao clicar no botão*/
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_cliente, new ListarFragment()).commit();
            }
        });

        /*Inflar o fragmento*/
        return v;
    }
}