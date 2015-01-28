package com.example.raul.myejercicio6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.view.View.OnClickListener;


public class MyActivity extends Activity {

    public static int COD_RESPUESTA = 0;
    final TextView tvRespuesta = (TextView) findViewById(R.id.tvRespuesta);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final Button btnPantalla2 = (Button) findViewById(R.id.btnPantalla2);
        final Button btnPantalla3 = (Button) findViewById(R.id.btnPantalla3);

        btnPantalla2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(MyActivity.this, Pantalla2.class);
                Bundle miBundle = new Bundle();
                miIntent.putExtras(miBundle);
                startActivityForResult(miIntent, COD_RESPUESTA);
            }
        });
        btnPantalla3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(MyActivity.this, Pantalla3.class);
                Bundle miBundle = new Bundle();
                miIntent.putExtras(miBundle);
                startActivityForResult(miIntent, COD_RESPUESTA);
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

    public void onActivityResult(int cod_resp, int cod_result, Intent intent) {
        if (cod_result == 2) {
            tvRespuesta.setText("Vengo de pantalla 2");

        }
        if (cod_result == 3) {
            tvRespuesta.setText("Vengo de pantalla 3");

        }


    }
}
