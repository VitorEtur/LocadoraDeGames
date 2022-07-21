package com.br.hustlei.agendex.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.br.hustlei.agendex.R;
import com.br.hustlei.agendex.cliente.Cliente;

public class DatabaseHelper extends SQLiteOpenHelper { /*Extendendo o banco de dados do SQLite*/

    private static final String DATABASE_NAME = "locadora"; /*Nome do banco de dados*/
    private static final String TABLE_CLIENTE = "cliente"; /*Criando tabela*/

    private static final String CREATE_TABLE_CLIENTE = "CREATE TABLE " + TABLE_CLIENTE + " (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nome VARCHAR(100), " +
            "cpf VARCHAR(30), " +
            "celular VARCHAR(15));";

    private static final String DROP_TABLE_CLIENTE = "DROP TABLE IF EXISTS " + TABLE_CLIENTE;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1); /*Acessar o método da classe pai */
    }

    @Override
    public void onCreate(SQLiteDatabase db) { /*Fazendo a criação do create table*/
        db.execSQL(CREATE_TABLE_CLIENTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { /*Atualizar a versão da tabela*/
        db.execSQL(DROP_TABLE_CLIENTE);
        onCreate(db);
    }

    /*Inicio CRUD Cliente*/
    public long createCliente (Cliente c) { /*Método de inserir no banco de dados*/
        SQLiteDatabase db = this.getWritableDatabase(); /*Instanciando o banco de dados*/
        ContentValues cv = new ContentValues();
        cv.put("nome", c.getNome());
        cv.put("cpf", c.getCpf());
        cv.put("celular", c.getCelular());
        long id = db.insert(TABLE_CLIENTE, null, cv);
        db.close();
        return id;
    }
    public long updateCliente (Cliente c) { /*Método de atualizar o banco de dados*/
        SQLiteDatabase db = this.getWritableDatabase(); /*Instanciando o banco de dados*/
        ContentValues cv = new ContentValues();
        cv.put("nome", c.getNome());
        cv.put("cpf", c.getCpf());
        cv.put("celular", c.getCelular());
        long id = db.update(TABLE_CLIENTE, cv,
                "_id = ?", new String[]{String.valueOf(c.getId())});
        db.close();
        return id;
    }
    public long deleteCliente (Cliente c) { /*Método para atualizar um item do banco de dados*/
        SQLiteDatabase db = this.getWritableDatabase(); /*Instanciando o banco de dados*/
        ContentValues cv = new ContentValues();

        long id = db.delete(TABLE_CLIENTE, "_id = ?",
                new String[]{String.valueOf(c.getId())});
        db.close();
        return id;
    }
    public void getAllCliente (Context context, ListView lv){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"_id", "nome", "celular"};
        Cursor data = db.query(TABLE_CLIENTE, columns, null, null,
                null, null, "nome");

        int[] to = {R.id.textViewIdListarCliente, R.id.textViewNomeListarCliente,
        R.id.textViewCelularListarCliente};
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(context,
                R.layout.cliente_item_list_view, data, columns, to, 0);
        lv.setAdapter(simpleCursorAdapter);
        db.close();
    }

    public Cliente getByIdCliente (int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"_id", "nome", "cpf", "celular"};
        String[] args = {String.valueOf(id)};
        Cursor data = db.query(TABLE_CLIENTE, columns, "_id = ?", args, null, null, null);
        data.moveToFirst();
        Cliente c = new Cliente();
        c.setId(data.getInt(0));
        c.setNome(data.getString(1));
        c.setCpf(data.getString(2));
        c.setCelular(data.getString(3));
        data.close();
        db.close();
        return c;
    }
    /*Fim CRUD Cliente*/
}
