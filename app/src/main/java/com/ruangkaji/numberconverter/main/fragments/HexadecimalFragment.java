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

public class HexadecimalFragment extends Fragment {

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

        return inflater.inflate(R.layout.fragment_main_hexadecimal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getActivity() instanceof MainActivity) {
            TextInputEditText inputHex = view.findViewById(R.id.txt_in_hexadecimal);
            TextInputEditText inputDec = view.findViewById(R.id.txt_in_decimal);
            TextInputEditText inputBin = view.findViewById(R.id.txt_in_binary);
            TextInputEditText inputOct = view.findViewById(R.id.txt_in_octal);
            viewModel.getHex().observe(getViewLifecycleOwner(), inputHex::setText);
            viewModel.getDec().observe(getViewLifecycleOwner(), inputDec::setText);
            viewModel.getBin().observe(getViewLifecycleOwner(), inputBin::setText);
            viewModel.getOct().observe(getViewLifecycleOwner(), inputOct::setText);

            view.findViewById(R.id.btn_clear).setOnClickListener(this::clear);
            view.findViewById(R.id.btn_delete).setOnClickListener(this::delHex);

            view.findViewById(R.id.btn_zero).setOnClickListener(this::setHex);
            view.findViewById(R.id.btn_one).setOnClickListener(this::setHex);
            view.findViewById(R.id.btn_two).setOnClickListener(this::setHex);
            view.findViewById(R.id.btn_three).setOnClickListener(this::setHex);
            view.findViewById(R.id.btn_four).setOnClickListener(this::setHex);
            view.findViewById(R.id.btn_five).setOnClickListener(this::setHex);
            view.findViewById(R.id.btn_six).setOnClickListener(this::setHex);
            view.findViewById(R.id.btn_seven).setOnClickListener(this::setHex);
            view.findViewById(R.id.btn_eight).setOnClickListener(this::setHex);
            view.findViewById(R.id.btn_nine).setOnClickListener(this::setHex);
            view.findViewById(R.id.btn_a).setOnClickListener(this::setHex);
            view.findViewById(R.id.btn_b).setOnClickListener(this::setHex);
            view.findViewById(R.id.btn_c).setOnClickListener(this::setHex);
            view.findViewById(R.id.btn_d).setOnClickListener(this::setHex);
            view.findViewById(R.id.btn_e).setOnClickListener(this::setHex);
            view.findViewById(R.id.btn_f).setOnClickListener(this::setHex);
        }
    }

    private void setHex(View v) {
        String add;
        switch (v.getId()) {
            default:
            case R.id.btn_zero:
                add = "0";
                break;
            case R.id.btn_one:
                add = "1";
                break;
            case R.id.btn_two:
                add = "2";
                break;
            case R.id.btn_three:
                add = "3";
                break;
            case R.id.btn_four:
                add = "4";
                break;
            case R.id.btn_five:
                add = "5";
                break;
            case R.id.btn_six:
                add = "6";
                break;
            case R.id.btn_seven:
                add = "7";
                break;
            case R.id.btn_eight:
                add = "8";
                break;
            case R.id.btn_nine:
                add = "9";
                break;
            case R.id.btn_a:
                add = "A";
                break;
            case R.id.btn_b:
                add = "B";
                break;
            case R.id.btn_c:
                add = "C";
                break;
            case R.id.btn_d:
                add = "D";
                break;
            case R.id.btn_e:
                add = "E";
                break;
            case R.id.btn_f:
                add = "F";
                break;
        }
        viewModel.addHex(add);
    }

    private void delHex(View v) {
        viewModel.delHex();
    }

    private void clear(View v) {
        viewModel.clear();
    }
}
