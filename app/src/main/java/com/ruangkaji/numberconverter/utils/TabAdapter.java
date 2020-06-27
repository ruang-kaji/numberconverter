package com.ruangkaji.numberconverter.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/*
 * Custom Tab Adapter class for handling fragments.
 *
 * Reference : https://medium.com/@droidbyme/android-material-design-tabs-tab-layout-with-swipe-884085ae80ff
 */
public class TabAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;
    private List<String> titleList;

    public TabAdapter(
            @NonNull FragmentManager fragmentManager,
            List<Fragment> fragmentList,
            List<String> titleList
    ) {
        super(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        if (fragmentList.size() != titleList.size())
            throw new IllegalArgumentException("Fragment list size different from title list.");

        this.fragmentList = fragmentList;
        this.titleList = titleList;
    }

    public TabAdapter(@NonNull FragmentManager fragmentManager) {
        this(fragmentManager, new ArrayList<Fragment>(), new ArrayList<String>());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    public void addFragment(@NonNull String title, @NonNull Fragment fragment) {
        this.titleList.add(title);
        this.fragmentList.add(fragment);
    }
}
