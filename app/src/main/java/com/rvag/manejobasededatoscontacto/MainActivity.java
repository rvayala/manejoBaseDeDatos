package com.rvag.manejobasededatoscontacto;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.rvag.manejobasededatoscontacto.database.DataBaseAdapter;
import com.rvag.manejobasededatoscontacto.view.ListaContactoActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtNombre;
    EditText edtEmail;
    EditText edtTwiter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getActionBar().setDisplayHomeAsUpEnabled(true);

        edtNombre = (EditText) findViewById(R.id.edtNombre);
        edtEmail = (EditText) findViewById(R.id.edtCorreo);
        edtTwiter = (EditText) findViewById(R.id.edtTwiter);

    }

    private void saveData(View view)
    {
        DataBaseAdapter dataBaseAdapter = new DataBaseAdapter(MainActivity.this, "miBaseDatos", null, 1);
        SQLiteDatabase acciones = dataBaseAdapter.getWritableDatabase();
        String name = edtNombre.getText().toString();
        String email = edtEmail.getText().toString();
        String twitter = edtTwiter.getText().toString();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("twitter", twitter);

        acciones.insert("user", null, contentValues);

        acciones.close();
        contentValues.clear();

        ShowSnackBar(view);
    }

    public void ShowSnackBar(View view)
    {
        Snackbar.make(view, "Registro almacenado", Snackbar.LENGTH_LONG)
              .setAction("Aceptar", new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      Intent intent = new Intent(MainActivity.this,ListaContactoActivity.class);
                      startActivity(intent);
                  }
              }).show();
    }
}
