package com.example.raul.ejemplolayout;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by raul on 16/10/2014.
 */
public class ClaseTabla extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }
    public void Boton1( View v){
        finish();
    }
}
