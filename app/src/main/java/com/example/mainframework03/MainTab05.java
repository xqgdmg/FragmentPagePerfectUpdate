package com.example.mainframework03;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mainframework03.base.MyBaseFragment;


public class MainTab05 extends MyBaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View newsLayout = inflater.inflate(R.layout.main_tab_05, container, false);
        return newsLayout;
    }

}
