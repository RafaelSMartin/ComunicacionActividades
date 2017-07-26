package com.rafaels.comunicacionactividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Rafael S. Martin on 04/01/2017.
 */

public class SegundaActividad extends Activity {

    private TextView texto;
    private Button bAceptar, bRechazar;

    public  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_actividad);

        texto = (TextView) findViewById(R.id.texto);
        recogerExtras();

        bAceptar = (Button) findViewById(R.id.buttonAceptar);
        bRechazar = (Button) findViewById(R.id.buttonRechazar);

        bAceptar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                lanzarActividad();
            }
        });

        bRechazar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                lanzarActividad();
            }
        });


    }

    public void recogerExtras() {
        //Aquí recogemos y tratamos los parámetros
        Bundle extras= getIntent().getExtras();
        String s = extras.getString("tTexto");
        texto.setText("Hola " + s +", ¿Aceptas las condiciones?");
    }

    public void lanzarActividad(){
        Intent i = new Intent();

        i.putExtra("bAceptar", bAceptar.toString());
        i.putExtra("bRechazar", bRechazar.toString());
        setResult(RESULT_OK, i);

        //startActivity(i);
        finish();

    }

}
