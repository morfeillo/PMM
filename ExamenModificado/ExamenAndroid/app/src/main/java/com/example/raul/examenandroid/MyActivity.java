package com.example.raul.examenandroid;

import android.app.Activity;
import android.content.Intent;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity extends Activity {

    public Spinner miSpinner;
    public String tipoZona;
    public String tipoRegion;
    public int tipoPrecio;
    public double total;
    public double peso;
    public boolean tarjeta=false;
    public boolean regalo=false;
    public String tarifa="normal";
    public double precioKilo;
    public String decoracion="";
    public static int COD_RESPUESTA=0;


    public Zona[] zona =
            new Zona[]{
                    new Zona("Zona A","Asia y Oceanía",30),
                    new Zona("Zona B:", "América y África",20),
                    new Zona("Zona C", "Europa",10),
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final Button btnCalculos = (Button) findViewById(R.id.btnCalculos);
        final RadioButton rbNormal = (RadioButton) findViewById(R.id.rbNormal);
        final RadioButton rbUrgente = (RadioButton) findViewById(R.id.rbUrgente);
        final CheckBox ckRegalo = (CheckBox) findViewById(R.id.ckRegalo);
        final CheckBox ckTarjeta = (CheckBox) findViewById(R.id.ckTarjeta);
        final EditText etPeso = (EditText) findViewById(R.id.etPeso);

        rbNormal.isChecked();
        miSpinner = (Spinner) findViewById(R.id.spinner);

        Adaptador miAdaptador = new Adaptador(this);
        miSpinner.setAdapter(miAdaptador);

     //   ClientesSQLiteHelper cliBDh = new ClientesSQLiteHelper(this, "DBEnvio", null, 1);
   //     final SQLiteDatabase bd = cliBDh.getWritableDatabase();


        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

              public void onItemSelected(AdapterView arg0, View arg1, int position, long id) {

               tipoZona = zona[position].getZona();
               tipoRegion = zona[position].getRegion();
               tipoPrecio = zona[position].getPrecio();
                }

               @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
        });
                btnCalculos.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        precioKilo=tipoPrecio;
                        recoger();
                        String dineroTotal = incremento(total).toString();
                      // bd.execSQL("INSERT INTO Envio" + " VALUES ('"+tipoZona+ "', '" +total+ "')");

                        /*
                        if (bd!=null) {
                            bd.execSQL("INSERT INTO Envio (zona,total) " +
                                    "VALUES ('"+tipoZona+"','"+total+"')");
                        }*/

                    //    bd.close();

                        Toast.makeText(getApplicationContext(),"Insertado en la BBDD",Toast.LENGTH_SHORT).show();
                        Intent miIntent = new Intent(MyActivity .this,Pantalla2.class);
                        Bundle miBundle = new Bundle();
                        miBundle.putString("zona",tipoZona);
                        miBundle.putString("region",tipoRegion);
                        miBundle.putString("tarifa",tarifa);
                        miBundle.putInt("precio",tipoPrecio);
                        miBundle.putInt("peso", (int) peso);
                        miBundle.putString("decoracion",decoracion);
                        miBundle.putString("dineroTotal", dineroTotal);
                        miIntent.putExtras(miBundle);
                        startActivity(miIntent);

                    }


        //recogo los datos y calculo el totl del precio por kilo
            public double recoger(){
                //paseo el edit text a double.
                peso=Double.parseDouble(etPeso.getText().toString());
                     //checkeo el tipo d peso que es para calcular el peso x kilo y calculo el preciototal.
                if (peso>5 && peso<10){
                total=(peso*1.5)*precioKilo;
                }
                else{
                    if (peso>10){
                        total=(peso*2)*precioKilo;
                    }
                    else{
                        total=peso*precioKilo;
                    }
                }
                return total;
            }
            // checkeo tarifa urgente y si esta clicked incremento el precio 30%
            public Double incremento(double total){
                if (rbUrgente.isChecked()==true){
                    total=total*0.3;
                    tarifa="urgente";
                }
                if (ckRegalo.isChecked()==true){
                    regalo=true;
                    decoracion="Para regalo";

                }
                if (ckTarjeta.isChecked()==true){
                    tarjeta=true;
                    decoracion= decoracion + " con tarjeta dedicatoria";
                }

                return total;
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
        if (id == R.id.MnuOpc1){
            //InsertarDB
         ClientesSQLiteHelper cliBDh = new ClientesSQLiteHelper(this, "DBEnvio", null, 1);
        final SQLiteDatabase bd = cliBDh.getWritableDatabase();

            bd.execSQL("INSERT INTO Envio " +"VALUES ("+tipoZona+", " + total + ")");
        }
        if (id == R.id.MnuOpc2){
             //Dibujo

                String dibujo="dibujo";

                Intent miIntent = new Intent(MyActivity.this, Pantalla3.class);
                Bundle miBundle = new Bundle();
                miBundle.putString("dibujo", dibujo);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);

                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    class Adaptador extends ArrayAdapter<Zona> {
        public Activity Actividad;

        public Adaptador(Activity laActividad){
            super(laActividad, R.layout.contenido_spinner, zona);
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
            holder.tipo.setText(zona[position].getZona() + "\n" + zona[position].getRegion()+ "\n"+ zona[position].getPrecio()+"€");
            //holder.tipo.setText(zona[position].getZona());
            return item;
        }

    }
}
