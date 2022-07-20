package com.br.hustlei.agendex.cliente;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.br.hustlei.agendex.R;

public class ListarFragment extends Fragment { /*Criando classe de fragmento da lista de clientes*/

    public ListarFragment() { } /*Classe lista de clientes*/

    @Override /*Método para sobrescrever/herdar de uma classe mãe/pai*/
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.cliente_fragment_listar, container, false);
    }
}