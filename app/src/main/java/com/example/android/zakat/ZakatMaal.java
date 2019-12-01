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

public class ZakatMaal extends Fragment {
    EditText et_total_kekayaan, et_harga_emas;
    Button btn_hitung_maal;

    public ZakatMaal() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zakat_maal, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        et_total_kekayaan = (EditText) getActivity().findViewById(R.id.et_total_kekayaan);
        et_harga_emas = (EditText) getActivity().findViewById(R.id.et_harga_emas);

        btn_hitung_maal = (Button) getActivity().findViewById(R.id.btn_hitung_maal);

        btn_hitung_maal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int kekayaan = Integer.parseInt(et_total_kekayaan.getText().toString());
                int emas = Integer.parseInt(et_harga_emas.getText().toString());

                if(kekayaan > (85 * emas)){
                    double zakat = 2.5 / 100 * kekayaan;
                    Log.v("Nilai Zakat Maal:", String.valueOf(zakat));

                    Intent intent = new Intent();
                    intent.putExtra("MESSAGE", zakat);
                    getActivity().setResult(Activity.RESULT_OK, intent);
                    getActivity().finish();
                } else {
                    double zakat = 0;
                    Log.v("Nilai Zakat Maal:", String.valueOf(zakat));

                    Intent intent = new Intent();
                    intent.putExtra("MESSAGE", zakat);
                    getActivity().setResult(Activity.RESULT_OK, intent);
                    getActivity().finish();
                }
            }
        });
    }
}
