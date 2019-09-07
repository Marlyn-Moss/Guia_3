package com.example.guia_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import static com.example.guia_3.TerceraActivity.lsNombre;
public class SegundaActivity extends AppCompatActivity implements View.OnLongClickListener {

    Button btnRegres, btnProcesar;
    EditText nombres;
    ProgressBar bar;
    boolean activo = false;
    int i = 0;
    Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        nombres = findViewById(R.id.txtnombre);
        btnRegres = findViewById(R.id.btnregres);
        btnProcesar = findViewById(R.id.btnProcesar);
        bar = findViewById(R.id.bar);



        btnRegres.setOnLongClickListener(this);
        btnProcesar.setOnLongClickListener(this);
    }

    public void mensaje(){
        String nombr = nombres.getText().toString();

        Toast.makeText(getApplicationContext(),"Nombre: " + nombr + " guardado con exito" , Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onLongClick(View view) {
        switch (view.getId()){
            case R.id.btnregres:{
                Toast.makeText(this, "Regresando a menu principal", Toast.LENGTH_LONG).show();
                Intent menu = new Intent(this, MainActivity.class);
                startActivity(menu);
            }
            break;

            case R.id.btnProcesar:{

                final String nombr = nombres.getText().toString();

                // Evaluamos si la variable nombre que es tipo string esta vacia o no
                if(!nombr.isEmpty()){
                    Thread carga = new Thread((new Runnable() {
                        @Override
                        public void run() {
                            while (i <= 1000){
                                h.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        bar.setProgress(i);
                                    }
                                });
                                try{
                                    Thread.sleep(1000);
                                }catch (InterruptedException e){
                                    e.printStackTrace();
                                }

                                if (i==100){
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {

                                            lsNombre.add(nombr);
                                            mensaje();
                                        }
                                    });
                                }

                                i = i+20;
                            }
                        }

                    }));
                    carga.start();
                    bar.setProgress(0);
                    i=0;
                }
            }
            break;
        }
        return false;
    }
}
