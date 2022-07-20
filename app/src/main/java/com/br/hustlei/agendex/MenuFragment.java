package com.br.hustlei.agendex;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class MenuFragment extends Fragment { //***Criando Fragmento de Menu

    public MenuFragment() { }

    @Override /*Método sobrescrever*/
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_cliente:
                Toast.makeText(getActivity(), "Menu Cliente", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_games:
                Toast.makeText(getActivity(), "Menu Games", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_locacao:
                Toast.makeText(getActivity(), "Menu Locação", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item); //***Vai pegar da classe fragment
    }
}