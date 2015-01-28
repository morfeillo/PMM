package com.example.raul.mycalculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        final Button btnCalcular = (Button)findViewById(R.id.btnCalcular);
        final RadioGroup rgBotones = (RadioGroup)findViewById(R.id.rgBotones);
        final RadioButton rdSuma = (RadioButton)findViewById(R.id.rbSumar);
        final RadioButton rdMulti = (RadioButton)findViewById(R.id.rbMulti);
        final RadioButton rdResta = (RadioButton)findViewById(R.id.rbRestar);
        final EditText etNum1 = (EditText)findViewById(R.id.etNum1);
        final EditText etNum2 = (EditText)findViewById(R.id.etNum2);
        final TextView tvResultado = (TextView)findViewById(R.id.tvResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int num1;
                final int num2;
                final int resultado;
                 String total="";
                if (rdSuma.isChecked()){
                    num1 = Integer.parseInt(etNum1.getText().toString());
                    num2 = Integer.parseInt(etNum2.getText().toString());
                    resultado=num1+num2;
                    total= ""+resultado;
                    tvResultado.setText(resultado);
                }
                else {
                    if (rdMulti.isChecked()){
                        num1 = Integer.parseInt(etNum1.getText().toString());
                        num2 = Integer.parseInt(etNum2.getText().toString());
                        resultado=num1*num2;
                        total= ""+resultado;
                        tvResultado.setText(resultado);
                    }
                    else {
                        if (rdResta.isChecked()){
                            num1=Integer.parseInt(etNum1.getText().toString());
                            num2 = Integer.parseInt(etNum2.getText().toString());
                            resultado=num1-num2;
                            total= ""+resultado;
                            tvResultado.setText(resultado);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Tienes que seleccionar una opción",Toast.LENGTH_SHORT);
                        }

                    }
                }
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
}
