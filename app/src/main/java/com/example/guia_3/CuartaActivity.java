package com.example.guia_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CuartaActivity extends AppCompatActivity implements View.OnClickListener{

    Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuarta);
        regresar = findViewById(R.id.btnregresar);

        regresar.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnregresar:
                Toast.makeText(this, "Regresando a menú principal", Toast.LENGTH_LONG).show();
                Intent cuarta = new Intent(this, MainActivity.class);
                startActivity(cuarta);
                break;
        }
    }
}
