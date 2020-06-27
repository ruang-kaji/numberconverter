package com.ruangkaji.numberconverter.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.ruangkaji.numberconverter.R;
import com.ruangkaji.numberconverter.main.fragments.BinaryFragment;
import com.ruangkaji.numberconverter.main.fragments.DecimalFragment;
import com.ruangkaji.numberconverter.main.fragments.HexadecimalFragment;
import com.ruangkaji.numberconverter.main.fragments.OctalFragment;
import com.ruangkaji.numberconverter.utils.TabAdapter;
import com.ruangkaji.numberconverter.utils.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabAdapter tabAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.fragment_container);
        tabLayout = findViewById(R.id.top_nav);

        tabAdapter = new TabAdapter(getSupportFragmentManager());
        tabAdapter.addFragment(
                getString(R.string.main_fragment_decimal_title),
                new DecimalFragment());
        tabAdapter.addFragment(
                getString(R.string.main_fragment_binary_title),
                new BinaryFragment());
        tabAdapter.addFragment(
                getString(R.string.main_fragment_octal_title),
                new OctalFragment());
        tabAdapter.addFragment(
                getString(R.string.main_fragment_hexadecimal_title),
                new HexadecimalFragment());

        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
