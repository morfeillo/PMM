package com.example.raul.examenandroid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

/**
 * Created by raul on 03/02/2015.
 */
public class Pantalla3 extends Activity {


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);

        String variable = getIntent().getStringExtra("dibujar");


        if (variable.equals("dibujo")) {
            setContentView(new Dibujo(this));

        }

    }

    class Dibujo extends View {
        public Dibujo(Context c) {
            super(c);
        }
        protected void onDraw(Canvas lienzo) {




        }
    }

}