package com.rvag.manejobasededatoscontacto.view;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.rvag.manejobasededatoscontacto.MainActivity;
import com.rvag.manejobasededatoscontacto.R;
import com.rvag.manejobasededatoscontacto.database.DataBaseAdapter;

import java.util.ArrayList;

public class ListaContactoActivity extends AppCompatActivity {

    ListView lstContacto;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contacto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        lstContacto = (ListView) findViewById(R.id.lstContactos);

        SetupFab();
        showData();
    }

    public  void SetupFab()
    {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showData()
    {
        DataBaseAdapter dataBaseAdapter = new DataBaseAdapter(ListaContactoActivity.this,
                "miBaseDatos",null, 1);


        ArrayList<String> nombreContacto = new ArrayList<>();

        SQLiteDatabase acciones = dataBaseAdapter.getReadableDatabase();
        Cursor registros = acciones.rawQuery("Select * From user", null);

        while (registros.moveToNext()){
            String nombre = registros.getString(1);
            nombreContacto.add(nombre);
        }

        acciones.close();
        registros.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListaContactoActivity.this,
                android.R.layout.simple_list_item_1, nombreContacto);

        lstContacto.setAdapter(adapter);
    }
}
