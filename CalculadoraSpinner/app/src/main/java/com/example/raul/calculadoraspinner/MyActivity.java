package com.example.raul.calculadoraspinner;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MyActivity extends Activity {

    public Spinner miSpinner;
    public String tipoOperacion;
    public int num1;
    public int num2;
    public int resultado;
    public String total = " ";


    public Operacion[] operaciones =
            new Operacion[]{
                    new Operacion("Eliga la Operacion a realizar:"),
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
        final TextView txResultado = (TextView)findViewById(R.id.txResultado);
        final TextView tvNum1= (TextView)findViewById(R.id.tvNum1);
        final TextView tvNum2= (TextView)findViewById(R.id.tvNum2);
        miSpinner = (Spinner) findViewById(R.id.spinner);


        Adaptador miAdaptador = new Adaptador(this);
        miSpinner.setAdapter(miAdaptador);


        ClientesSQLiteHelper cliBDh = new ClientesSQLiteHelper(this, "DBOperacion", null, 1);
        final SQLiteDatabase bd = cliBDh.getWritableDatabase();

        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {

                tipoOperacion=operaciones[position].getTipo();



                switch(position){
                    case 0:
                       // ocultarTodo();
                        break;
                    case 1:
                     //   mostrar();
                        btnOperar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                num1 = Integer.parseInt(edNum1.getText().toString());
                                num2 = Integer.parseInt(edNum2.getText().toString());
                                resultado = num1 + num2;
                                total = " " + resultado;
                                txResultado.setText(total);


                                bd.execSQL("INSERT INTO Resultado " +
                                        "VALUES (" + total + ", 'suma')");
                            }
                        });


                        break;

                    case 2:
                     //   mostrar();
                        btnOperar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                num1 = Integer.parseInt(edNum1.getText().toString());
                                num2 = Integer.parseInt(edNum2.getText().toString());
                                resultado = num1 - num2;
                                total = " " + resultado;
                                txResultado.setText(total);
                                bd.execSQL("INSERT INTO Resultado (total, operacion) " +
                                        "VALUES (" + total + ", 'resta')");
                            }
                        });

                        break;
                    case 3:
                       // mostrar();
                        btnOperar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                num1 = Integer.parseInt(edNum1.getText().toString());
                                num2 = Integer.parseInt(edNum2.getText().toString());
                                resultado = num1 * num2;
                                total = " " + resultado;
                                txResultado.setText(total);
                                bd.execSQL("INSERT INTO Resultado (total, operacion) " +
                                        "VALUES (" + total + ", 'multiplicacion')");

                            }
                        });
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

            public void ocultarTodo(){
                txResultado.setVisibility(View.INVISIBLE);
                btnOperar.setVisibility(View.INVISIBLE);
                tvNum1.setVisibility(View.INVISIBLE);
                tvNum2.setVisibility(View.INVISIBLE);
                edNum1.setVisibility(View.INVISIBLE);
                edNum2.setVisibility(View.INVISIBLE);
            }
            public void mostrar(){
                txResultado.setVisibility(View.VISIBLE);
                btnOperar.setVisibility(View.INVISIBLE);
                tvNum1.setVisibility(View.INVISIBLE);
                tvNum2.setVisibility(View.INVISIBLE);
                edNum1.setVisibility(View.INVISIBLE);
                edNum2.setVisibility(View.INVISIBLE);

            }




        });


    }

    class Adaptador extends ArrayAdapter<Operacion> {
        public Activity Actividad;

        public Adaptador(Activity laActividad){
            super(laActividad, R.layout.contenido_spinner, operaciones);
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
            holder.tipo.setText(operaciones[position].getTipo());
            return item;
        }
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
