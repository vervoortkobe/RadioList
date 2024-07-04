package com.example.radiolist;

import com.example.radiolist.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private Spinner spinner;
    private static final String[] paths = {"JoeFM", "MNM", "Nostalgie", "Qmusic", "Radio 1", "Radio 2", "StuBru"};
    public static boolean joefm = false;
    public static boolean klara = false;
    public static boolean mnm = false;
    public static boolean nostalgie = false;
    public static boolean qmusic = false;
    public static boolean radio1 = false;
    public static boolean radio2 = false;
    public static boolean stubru = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Deze functie werkt nog niet en is waardeloos :)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                joefm = true;
                mnm = false;
                nostalgie = false;
                qmusic = false;
                radio1 = false;
                radio2 = false;
                stubru = false;
                break;
            case 1:
                joefm = false;
                mnm = true;
                nostalgie = false;
                qmusic = false;
                radio1 = false;
                radio2 = false;
                stubru = false;
                break;
            case 2:
                joefm = false;
                mnm = false;
                nostalgie = true;
                qmusic = false;
                radio1 = false;
                radio2 = false;
                stubru = false;
                break;
            case 3:
                joefm = false;
                mnm = false;
                nostalgie = false;
                qmusic = true;
                radio1 = false;
                radio2 = false;
                stubru = false;
                break;
            case 4:
                joefm = false;
                mnm = false;
                nostalgie = false;
                qmusic = false;
                radio1 = true;
                radio2 = false;
                stubru = false;
                break;
            case 5:
                joefm = false;
                mnm = false;
                nostalgie = false;
                qmusic = false;
                radio1 = false;
                radio2 = true;
                stubru = false;
                break;
            case 6:
                joefm = false;
                mnm = false;
                nostalgie = false;
                qmusic = false;
                radio1 = false;
                radio2 = false;
                stubru = true;
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub
    }
}