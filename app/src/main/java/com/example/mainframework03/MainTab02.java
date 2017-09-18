package com.example.mainframework03;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mainframework03.base.MyBaseFragment;

public class MainTab02 extends MyBaseFragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View messageLayout = inflater.inflate(R.layout.main_tab_02, container, false);
        return messageLayout;
    }

}
