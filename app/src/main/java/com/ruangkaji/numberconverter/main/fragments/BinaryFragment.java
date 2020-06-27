package com.ruangkaji.numberconverter.main.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputEditText;
import com.ruangkaji.numberconverter.R;
import com.ruangkaji.numberconverter.main.MainActivity;
import com.ruangkaji.numberconverter.main.models.MainViewModel;

public class BinaryFragment extends Fragment {

    private MainViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        super.onCreateView(inflater, container, savedInstanceState);

        if (getActivity() instanceof MainActivity) {
            viewModel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
        }

        return inflater.inflate(R.layout.fragment_main_binary, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getActivity() instanceof MainActivity) {
            TextInputEditText inputBin = view.findViewById(R.id.txt_in_binary);
            TextInputEditText inputDec = view.findViewById(R.id.txt_in_decimal);
            TextInputEditText inputOct = view.findViewById(R.id.txt_in_octal);
            TextInputEditText inputHex = view.findViewById(R.id.txt_in_hexadecimal);
            viewModel.getBin().observe(getViewLifecycleOwner(), inputBin::setText);
            viewModel.getDec().observe(getViewLifecycleOwner(), inputDec::setText);
            viewModel.getOct().observe(getViewLifecycleOwner(), inputOct::setText);
            viewModel.getHex().observe(getViewLifecycleOwner(), inputHex::setText);

            view.findViewById(R.id.btn_clear).setOnClickListener(this::clear);
            view.findViewById(R.id.btn_delete).setOnClickListener(this::delBin);

            view.findViewById(R.id.btn_zero).setOnClickListener(this::setBin);
            view.findViewById(R.id.btn_one).setOnClickListener(this::setBin);
        }
    }

    private void setBin(View v) {
        String add;
        switch (v.getId()) {
            default:
            case R.id.btn_zero:
                add = "0";
                break;
            case R.id.btn_one:
                add = "1";
                break;
        }
        viewModel.addBin(add);
    }

    private void delBin(View v) {
        viewModel.delBin();
    }

    private void clear(View v) {
        viewModel.clear();
    }
}
