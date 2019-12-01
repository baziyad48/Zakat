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

public class ZakatFitrah extends Fragment {
    EditText et_harga_beras, et_jumlah_orang;
    Button btn_hitung_fitrah;

    public ZakatFitrah() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_zakat_fitrah, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        et_harga_beras = (EditText) getActivity().findViewById(R.id.et_harga_beras);
        et_jumlah_orang = (EditText) getActivity().findViewById(R.id.et_jumlah_orang);

        btn_hitung_fitrah = (Button) getActivity().findViewById(R.id.btn_hitung_fitrah);

        btn_hitung_fitrah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int beras = Integer.parseInt(et_harga_beras.getText().toString());
                int jumlah = Integer.parseInt(et_jumlah_orang.getText().toString());
                double zakat = beras * jumlah * 2.5;
                Log.v("Nilai Zakat Fitrah:", String.valueOf(zakat));

                Intent intent = new Intent();
                intent.putExtra("MESSAGE", zakat);
                getActivity().setResult(Activity.RESULT_OK, intent);
                getActivity().finish();
            }
        });
    }
}
