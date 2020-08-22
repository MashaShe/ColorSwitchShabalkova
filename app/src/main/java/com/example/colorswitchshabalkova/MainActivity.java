package com.example.colorswitchshabalkova;


import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    String selectedItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Utils.onActivityCreateSetTheme(MainActivity.this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button ok = findViewById(R.id.button_ok);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.lang_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final Spinner spinnerCol = (Spinner) findViewById(R.id.spinnerColor);
        ArrayAdapter<CharSequence> adapterCol = ArrayAdapter.createFromResource(this,
                R.array.col_array, android.R.layout.simple_spinner_item);
        adapterCol.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCol.setAdapter(adapterCol);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String langItem = spinner.getSelectedItem().toString();
                String lang ="ru";
                if (langItem.equals("Русский") || langItem.equals("Russian")) {
                    lang = "ru";
                }
                if (langItem.equals("Английский") || langItem.equals("English")) {
                    lang = "en";
                }
                String colorItem = spinnerCol.getSelectedItem().toString();
                if (colorItem.equals("Черный") || colorItem.equals("Black")) {
                    Utils.changeToTheme(MainActivity.this, Utils.THEME_DEFAULT);
                }
                if (colorItem.equals("Зеленый") || colorItem.equals("Green")) {
                    Utils.changeToTheme(MainActivity.this, Utils.THEME_GREEN);
                }
                if (colorItem.equals("Синий") || colorItem.equals("Blue")) {
                    Utils.changeToTheme(MainActivity.this, Utils.THEME_BLUE);
                }

                Locale locale = new Locale(lang);
                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                recreate();


            }
        });

    }
}

