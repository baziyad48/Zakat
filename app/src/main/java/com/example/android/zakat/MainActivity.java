package com.example.android.zakat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_penghasilan, btn_maal, btn_fitrah;
    TextView tv_hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_penghasilan = (Button) findViewById(R.id.btn_penghasilan);
        btn_maal = (Button) findViewById(R.id.btn_maal);
        btn_fitrah = (Button) findViewById(R.id.btn_fitrah);

        tv_hasil = (TextView) findViewById(R.id.tv_hasil);

        btn_penghasilan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HitungZakatIntent.class);
                intent.putExtra("ZAKAT", 0);
                startActivityForResult(intent, 0);
            }
        });

        btn_maal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HitungZakatIntent.class);
                intent.putExtra("ZAKAT", 1);
                startActivityForResult(intent, 1);
            }
        });

        btn_fitrah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HitungZakatIntent.class);
                intent.putExtra("ZAKAT", 2);
                startActivityForResult(intent, 2);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK){
            double message = data.getDoubleExtra("MESSAGE", 0);
            Log.v("Nilai message:", String.valueOf(message));
            tv_hasil.setText("Rp. " +String.valueOf(message));
        }
    }
}
