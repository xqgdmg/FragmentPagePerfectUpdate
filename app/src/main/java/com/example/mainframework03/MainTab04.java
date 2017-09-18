package com.example.mainframework03;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mainframework03.base.MyBaseFragment;
import com.example.mainframework03.other.MSG;

public class MainTab04 extends MyBaseFragment {
    Button btnInto05 = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View newsLayout = inflater.inflate(R.layout.main_tab_04, container,false);
        btnInto05 = (Button) newsLayout.findViewById(R.id.tab04_btnInto05);
        btnInto05.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onEventListener != null) {
                    onEventListener.onEvent(MSG.INTO_05, null, null); // 这个发消息，奇葩
                }
            }
        });
        return newsLayout;
    }
}
