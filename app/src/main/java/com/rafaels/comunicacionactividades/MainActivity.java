package com.rafaels.comunicacionactividades;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.data;

public class MainActivity extends Activity {

    private Button bVerificar;
    private EditText tTexto;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoResultado = (TextView) findViewById(R.id.textResultado);
        tTexto = (EditText) findViewById(R.id.editText);
        bVerificar = (Button) findViewById(R.id.buttonVerificar);

        bVerificar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                lanzarVerificar(view, tTexto.getText().toString());

            }
        });

    }

    public void lanzarVerificar(View view, String tTexto){
        Intent i = new Intent(this, SegundaActividad.class);

        // + logico u OR, devuelve true si alguno es true.
        if(tTexto.equals("")||tTexto.equals(null)){
            i.putExtra("tTexto", "Anonimo");
        } else {
            i.putExtra("tTexto",tTexto.toString());
        }

        //startActivity(i);
        startActivityForResult(i, 1234);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1234 && resultCode == Activity.RESULT_OK){

            String bAceptar = data.getExtras().getString("bAceptar");
            String bRechazar = data.getExtras().getString("bRechazar");

            if(bRechazar.equals(null)) {
                textoResultado.setText("Rechazar");
            } else {
                textoResultado.setText("Aceptar");
            }
        }
    }
}
