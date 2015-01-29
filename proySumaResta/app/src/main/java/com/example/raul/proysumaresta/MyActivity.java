package com.example.raul.proysumaresta;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.INVISIBLE;


public class MyActivity extends Activity {

    public static int COD_RESPUESTA=0;
    public Spinner miSpinner;

    public Operacion[] figuras =
            new Operacion[]{
                    new Operacion("Suma"),
                    new Operacion("Resta"),
                    new Operacion("Multiplicacion")
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        final Button btnOperar = (Button)findViewById(R.id.btnOperar);
        final EditText edNum1 = (EditText)findViewById(R.id.edNum1);
        final EditText edNum2 = (EditText)findViewById(R.id.edNum2);
        final RadioGroup rgBotones = (RadioGroup)findViewById(R.id.rgBotones);
        final TextView txResultado = (TextView)findViewById(R.id.txResultado);
        final RadioButton rbSumar = (RadioButton)findViewById(R.id.rbSumar);
        final RadioButton rbRestar = (RadioButton)findViewById(R.id.rbRestar);
        final CheckBox cbDivertir = (CheckBox)findViewById(R.id.cbDivertir);
        final ImageView imgImage = (ImageView)findViewById(R.id.imgImagen);
        miSpinner = (Spinner) findViewById(R.id.spinner);

        Adaptador miAdaptador = new Adaptador(this);
        miSpinner.setAdapter(miAdaptador);


        btnOperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int num1;
                final int num2;
                String total = " ";

                if (rbSumar.isChecked()) {
                    num1 = Integer.parseInt(edNum1.getText().toString());
                    num2 = Integer.parseInt(edNum2.getText().toString());
                    int resultado = num1 + num2;
                    total = " " + resultado;
                    txResultado.setText(total);
                } else if (rbRestar.isChecked()) {
                    num1 = Integer.parseInt(edNum1.getText().toString());
                    num2 = Integer.parseInt(edNum2.getText().toString());
                    int resultado = num1 - num2;
                    total = " " + resultado;
                    txResultado.setText(total);
                } else {
                    Toast.makeText(getApplicationContext(), "Tienes que seleccionar una opción", Toast.LENGTH_SHORT);
                }

            }


        });
        cbDivertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbDivertir.isChecked()){
                    imgImage.setVisibility(View.VISIBLE);
                }
                else{
                    imgImage.setVisibility(INVISIBLE);
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

    class Adaptador extends ArrayAdapter<Operacion> {
        public Activity Actividad;

        public Adaptador(Activity laActividad){
            super(laActividad, R.layout.contenido_spinner, figuras);
            this.Actividad=laActividad;
        }

        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vistaDesplegada=getView(position, convertView, parent);
            return vistaDesplegada;
        }

        public View getView(int position, View convertView, ViewGroup parent){
            View item=convertView;
            ViewHolder holder;

            if(item==null) {
                LayoutInflater inflater = Actividad.getLayoutInflater();
                item = inflater.inflate(R.layout.contenido_spinner, null);
                holder = new ViewHolder();
                holder.tipo = (TextView) item.findViewById(R.id.campoTipo);
                item.setTag(holder);
            }else{
                holder=(ViewHolder)item.getTag();
            }
            holder.tipo.setText(figuras[position].getTipo());
            return item;
        }
    }

}
