package com.rvag.manejobasededatoscontacto.view;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Robert on 23/07/2016.
 */
public interface IListaContactosActivity {

    void setUpFAB();
    ArrayAdapter<String> createAdapter(ArrayList<String> nombreContacto);
    void setAdapterListView(ArrayAdapter<String> adapter);
}
