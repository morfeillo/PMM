package com.example.raul.juegosolobici;

/**
 * Created by raul on 02/12/2014.
 */
import android.app.Activity;
import android.os.Bundle;

public class AcercaDe extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Hacemos visible la interfaz/layoutque se encuentra en acercade.xml
        setContentView(R.layout.acercade);
    }
}