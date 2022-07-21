package com.br.hustlei.agendex.cliente;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.br.hustlei.agendex.R;
import com.br.hustlei.agendex.database.DatabaseHelper;

public class ListarFragment extends Fragment { /*Criando classe de fragmento da lista de clientes*/

    public ListarFragment() { } /*Classe lista de clientes*/

    @Override /*Método para sobrescrever/herdar de uma classe mãe/pai*/
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cliente_fragment_listar, container, false);

        DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
        ListView lv = v.findViewById(R.id.list_view_listar_clientes);
        databaseHelper.getAllCliente(getActivity(), lv);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                TextView tvId = view.findViewById(R.id.textViewIdListarCliente);
                Bundle b = new Bundle();
                b.putInt("id", Integer.parseInt(tvId.getText().toString()));

                EditarFragment editar = new EditarFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                editar.setArguments(b);
                ft.replace(R.id.frame_cliente, editar).commit();
            }
        });
        // Inflate the layout for this fragment
        return v;
    }
}