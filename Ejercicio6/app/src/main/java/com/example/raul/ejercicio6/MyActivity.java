package com.example.raul.ejercicio6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MyActivity extends Activity {

    public static int COD_RESPUESTA=0;
    final TextView tvPantalla1 = (TextView)findViewById(R.id.tvPantalla1);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final Button btnPantalla2 = (Button)findViewById(R.id.btnPantalla2);
        final Button btnPantalla3 = (Button)findViewById(R.id.btnPantalla3);


        btnPantalla2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this, Pantalla2.class);
                Bundle bundle = new Bundle();
                intent.putExtras(bundle);
                startActivityForResult(intent, COD_RESPUESTA );

            }
        });
        btnPantalla3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this, Pantalla3.class);
                Bundle bundle = new Bundle();
                intent.putExtras(bundle);
                startActivityForResult(intent, COD_RESPUESTA );


            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void onActivityResult(int cod_resp, int cod_result,Intent intent){
        if (cod_resp==2 ) {
            tvPantalla1.setText("Pantalla 1, Vengo de Pantalla 2");
        }
        if (cod_resp==3)
        {
            tvPantalla1.setText("Pantalla 1, Vengo de Pantalla 3");
        }
    }
}
