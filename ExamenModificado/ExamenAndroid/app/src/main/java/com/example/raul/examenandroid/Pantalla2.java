package com.example.raul.examenandroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by raul on 29/01/2015.
 */
public class Pantalla2 extends Activity{

    String zona,tarifa,peso,decoracion1,total;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);


        final TextView tvzona = (TextView)findViewById(R.id.tvZona);
        final TextView tvtarifa = (TextView)findViewById(R.id.tvTarifa);
        final TextView tvpeso = (TextView)findViewById(R.id.tvPeso);
        final TextView tvdecoracion = (TextView)findViewById(R.id.tvDecoracion);
        final TextView tvtotal =(TextView)findViewById(R.id.tvFinal);

        Bundle miBundleRecoger = getIntent().getExtras();
        zona=miBundleRecoger.getString("zona")+"("+miBundleRecoger.getString("region")+")";
        tvzona.setText("Zona: "+zona);
        tarifa=miBundleRecoger.getString("tarifa");
        tvtarifa.setText("Tarifa: "+tarifa);
        peso=Integer.toString(miBundleRecoger.getInt("peso"));

        tvpeso.setText("Peso: "+peso+"Kg");
        decoracion1=miBundleRecoger.getString("decoracion");
        tvdecoracion.setText("Decoración: "+decoracion1);
        total=miBundleRecoger.getString("dineroTotal");
        tvtotal.setText("Total: "+total+"€");

    }


}
