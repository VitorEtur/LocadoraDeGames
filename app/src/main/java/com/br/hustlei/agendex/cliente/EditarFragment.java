package com.br.hustlei.agendex.cliente;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

public class EditarFragment extends Fragment {

    private EditText etNome;
    private EditText etCpf;
    private EditText etCelular;
    private DatabaseHelper databaseHelper;
    private Cliente c;


    public EditarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.cliente_fragment_editar, container, false);

        etNome = v.findViewById(R.id.editText_nome_cliente);
        etCpf = v.findViewById(R.id.editText_cpf_cliente);
        etCelular = v.findViewById(R.id.editText_celular_cliente);

        Bundle b = getArguments();
        int id_cliente = b.getInt("id");
        databaseHelper = new DatabaseHelper(getActivity());
        c = databaseHelper.getByIdCliente(id_cliente);

        etNome.setText(c.getNome());
        etCpf.setText(c.getCpf());
        etCelular.setText(c.getCelular());

        Button btnEditar = v.findViewById(R.id.button_editar_cliente); /*Evento para navegar entre telas ao clicar no botão*/
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editar(id_cliente);
            }
        });
        Button btnExcluir = v.findViewById(R.id.button_excluir_cliente); /*Evento para navegar entre telas ao clicar no botão*/
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(R.string.excluir_cliente_mensagem);
                builder.setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        excluir(id_cliente);
                    }
                });
                builder.setNegativeButton(R.string.nao, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        /*Não faz nada*/
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        return v;
    }

    private void editar(int id) {

        if (etNome.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Por favor informe o nome do cliente", Toast.LENGTH_LONG).show();

        }else if (etCpf.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Por favor informe o CPF do cliente", Toast.LENGTH_LONG).show();

        }else if (etCelular.getText().toString().equals("")) {
            Toast.makeText(getActivity(), "Por favor informe o celular do cliente", Toast.LENGTH_LONG).show();

        }else {
            c = new Cliente();
            c.setId(id);
            c.setNome(etNome.getText().toString());
            c.setCpf(etCpf.getText().toString());
            c.setCelular(etCelular.getText().toString());
            databaseHelper.updateCliente(c);
            Toast.makeText(getActivity(), "Cliente atualizado", Toast.LENGTH_LONG).show();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_cliente, new ListarFragment()).commit();
        }
    }

    private void excluir(int id) {

        c = new Cliente();
        c.setId(id);
        databaseHelper.deleteCliente(c);

        Toast.makeText(getActivity(), "Cliente excluído", Toast.LENGTH_LONG).show();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_cliente, new ListarFragment()).commit();
    }
}