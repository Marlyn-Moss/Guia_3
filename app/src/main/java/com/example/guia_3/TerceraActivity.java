package com.example.guia_3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TerceraActivity extends AppCompatActivity{

    public ListView lstNombres;
    public static List<String> lsNombre = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);

        lstNombres = findViewById(R.id.lstNombres);

        lstNombres.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lsNombre));
    }

}
