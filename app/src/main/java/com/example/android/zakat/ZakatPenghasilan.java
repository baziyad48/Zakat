package com.example.android.zakat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class ZakatPenghasilan extends Fragment {
    EditText et_gaji_bulanan, et_cicilan_hutang, et_harga_beras_penghasilan;
    Button btn_hitung_penghasilan;

    public ZakatPenghasilan() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zakat_penghasilan, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        et_gaji_bulanan = (EditText) getActivity().findViewById(R.id.et_gaji_bulanan);
        et_cicilan_hutang = (EditText) getActivity().findViewById(R.id.et_cicilan_hutang);
        et_harga_beras_penghasilan = (EditText) getActivity().findViewById(R.id.et_harga_beras_penghasilan);

        btn_hitung_penghasilan = (Button) getActivity().findViewById(R.id.btn_hitung_penghasilan);

        btn_hitung_penghasilan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int gaji = Integer.parseInt(et_gaji_bulanan.getText().toString());
                int cicilan = Integer.parseInt(et_cicilan_hutang.getText().toString());
                int beras = Integer.parseInt(et_harga_beras_penghasilan.getText().toString());

                if((gaji - cicilan) > 520 * beras){
                    double zakat = (gaji - cicilan) * 2.5 / 100;
                    Log.v("Nilai Penghasilan:", String.valueOf(zakat));

                    Intent intent = new Intent();
                    intent.putExtra("MESSAGE", zakat);
                    getActivity().setResult(Activity.RESULT_OK, intent);
                    getActivity().finish();
                } else {
                    double zakat = 0;
                    Log.v("Nilai Penghasilan:", String.valueOf(zakat));

                    Intent intent = new Intent();
                    intent.putExtra("MESSAGE", zakat);
                    getActivity().setResult(Activity.RESULT_OK, intent);
                    getActivity().finish();
                }
            }
        });
    }
}
