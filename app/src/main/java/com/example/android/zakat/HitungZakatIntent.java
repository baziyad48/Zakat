package com.example.android.zakat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class HitungZakatIntent extends AppCompatActivity {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung_zakat_intent);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        int zakat = getIntent().getExtras().getInt("ZAKAT");
        Log.v("Nilai Intent", String.valueOf(zakat));

        if(zakat == 0){
            ZakatPenghasilan fragment = new ZakatPenghasilan();
            fragmentTransaction.add(R.id.frame_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }else if(zakat == 1){
            ZakatMaal fragment = new ZakatMaal();
            fragmentTransaction.add(R.id.frame_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else if(zakat == 2){
            ZakatFitrah fragment = new ZakatFitrah();
            fragmentTransaction.add(R.id.frame_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
