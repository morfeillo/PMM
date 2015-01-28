package com.example.raul.solobici;

/**
 * Created by raul on 26/12/2014.
 */
import android.os.Bundle;
import android.preference.PreferenceActivity;

import static com.example.raul.solobici.R.xml.preferencias;

public class Preferencias extends PreferenceActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(preferencias);
    }

}
