package com.example.guia_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.guia_3.TerceraActivity.lsNombre;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static List<String> listNom = new ArrayList<>();

    Button Agregar;
    Button VerList;
    Button VerDat;

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Agregar = findViewById(R.id.btnLista);
        VerList = findViewById(R.id.btnVer);
        VerDat = findViewById(R.id.btnDatos);
        listNom = new ArrayList<>();

        Agregar.setOnClickListener(this);
        VerList.setOnClickListener(this);
        VerDat.setOnClickListener(this);
    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLista: {
                Toast.makeText(this, "Agregar Lista", Toast.LENGTH_LONG).show();
                Intent segunda = new Intent(this, SegundaActivity.class);
                startActivity(segunda);
            }
                break;

            case R.id.btnVer: {
                if (!lsNombre.isEmpty()){
                    Toast.makeText(this, "Ver Lista", Toast.LENGTH_LONG).show();
                    Intent tercera = new Intent(this, TerceraActivity.class);
                    startActivity(tercera);
                }else {
                    Toast.makeText(this, "Lista Vacia", Toast.LENGTH_LONG).show();
                }
            }
                break;

            case R.id.btnDatos: {
                Toast.makeText(this, "BIENVENIDO", Toast.LENGTH_LONG).show();
                Intent cuarta = new Intent(this, CuartaActivity.class);
                startActivity(cuarta);
            }
                break;
        }
    }

}


