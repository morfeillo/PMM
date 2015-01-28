package com.example.raul.ejemplolayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        final Button Boton1=(Button)findViewById(R.layout.Boton1);
        final Button Boton2=(Button)findViewById(R.layout.Boton2);

        Boton1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(this.ClaseTabla.class);
                startActivity(miIntent);
            }
        });
    }
    Boton2.setOnClickListener( new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent miIntent = new Intent(this.ClaseGrid.class);
            startActivity(miIntent);
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
