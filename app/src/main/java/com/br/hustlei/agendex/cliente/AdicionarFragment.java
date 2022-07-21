package com.br.hustlei.agendex.cliente;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.br.hustlei.agendex.R;
import com.br.hustlei.agendex.database.DatabaseHelper;

public class AdicionarFragment extends Fragment { /*Classe Adicionar*/

    private EditText etNome;
    private EditText etCpf;
    private EditText etCelular;

    public AdicionarFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cliente_fragment_adicionar, container, false);

        etNome = v.findViewById(R.id.editText_nome_cliente);
        etCpf = v.findViewById(R.id.editText_cpf_cliente);
        etCelular = v.findViewById(R.id.editText_celular_cliente);

        Button btnAdicionar = v.findViewById(R.id.button_adicionar_cliente); /*Evento para navegar entre telas ao clicar no botão*/
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adicionar();
            }
        });


        // Inflate the layout for this fragment
        return v;
    }

    private void adicionar() {

        if (etNome.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Por favor informe o nome do cliente", Toast.LENGTH_LONG).show();

        }else if (etCpf.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Por favor informe o CPF do cliente", Toast.LENGTH_LONG).show();

        }else if (etCelular.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Por favor informe o celular do cliente", Toast.LENGTH_LONG).show();

        }else {
            DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
            Cliente c = new Cliente();
            c.setNome(etNome.getText().toString());
            c.setCpf(etCpf.getText().toString());
            c.setCelular(etCelular.getText().toString());
            databaseHelper.createCliente(c);
            Toast.makeText(getActivity(), "Cliente salvo", Toast.LENGTH_LONG).show();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_cliente, new ListarFragment()).commit();
        }
    }
}