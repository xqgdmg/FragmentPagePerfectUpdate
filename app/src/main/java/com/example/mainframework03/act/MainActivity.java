package com.example.mainframework03.act;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.mainframework03.base.BaseFragment;
import com.example.mainframework03.MainTab01;
import com.example.mainframework03.MainTab02;
import com.example.mainframework03.MainTab03;
import com.example.mainframework03.MainTab04;
import com.example.mainframework03.MainTab05;
import com.example.mainframework03.R;
import com.example.mainframework03.other.Common;
import com.example.mainframework03.other.MSG;

public class MainActivity extends FragmentActivity implements BaseFragment.OnEventListener {

    ViewPager viewPager;
    FragmentPagerAdapter adapter;

    MainTab01 tab01 = new MainTab01();
    MainTab02 tab02 = new MainTab02();
    MainTab03 tab03 = new MainTab03();
    MainTab04 tab04 = new MainTab04();
    MainTab05 tab05 = new MainTab05();
    Fragment[] fragments = {tab01, tab02, tab03, tab04};
    boolean[] fragmentsUpdateFlag = {false, false, false, false}; // 标记每个位置是否需要替换

    private LinearLayout tabBtnWeixin;
    private LinearLayout tabBtnFrd;
    private LinearLayout tabBtnAddress;
    private LinearLayout tabBtnSettings;

    Handler mainHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG.INTO_05:
                    fragments[3] = tab05; // 改变 Fragment 集合
                    fragmentsUpdateFlag[3] = true;
                    adapter.notifyDataSetChanged();
                    break;
                default:
            }
        }
    };

    /*
     * FragmentPagerAdapter
     */
    class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        FragmentManager fm;

        MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
            this.fm = fm;
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = fragments[position % fragments.length];
            Log.i(Common.TAG, "getItem:position=" + position + ",fragment:"
                    + fragment.getClass().getName() + ",fragment.tag="
                    + fragment.getTag());
            return fragments[position % fragments.length];
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        /*
         * 初始化的时候调用，只看这里就可以了
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Fragment fragment = (Fragment) super.instantiateItem(container, position);
            String fragmentTag = fragment.getTag();

             // 如果需要更新，就移除后添加。      fragmentsUpdateFlag 标记每个位置是否需要替换
            if (fragmentsUpdateFlag[position % fragmentsUpdateFlag.length]) {

                FragmentTransaction ft = fm.beginTransaction();
                ft.remove(fragment);
                fragment = fragments[position % fragments.length];
                ft.add(container.getId(), fragment, fragmentTag);
                ft.attach(fragment);
                ft.commit();

                 // 处理后复位
                fragmentsUpdateFlag[position % fragmentsUpdateFlag.length] = false;
            }
            return fragment;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.id_viewpager);

        tabBtnWeixin = (LinearLayout) findViewById(R.id.id_tab_bottom_weixin);
        tabBtnFrd = (LinearLayout) findViewById(R.id.id_tab_bottom_friend);
        tabBtnAddress = (LinearLayout) findViewById(R.id.id_tab_bottom_contact);
        tabBtnSettings = (LinearLayout) findViewById(R.id.id_tab_bottom_setting);

        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        viewPager.setOnPageChangeListener(new OnPageChangeListener() {

            private int currentIndex;

            @Override
            public void onPageSelected(int position) {
                resetTabBtn();
                switch (position) {
                    case 0:
                        ((ImageButton) tabBtnWeixin
                                .findViewById(R.id.btn_tab_bottom_weixin))
                                .setImageResource(R.drawable.tab_weixin_pressed);
                        break;
                    case 1:
                        ((ImageButton) tabBtnFrd
                                .findViewById(R.id.btn_tab_bottom_friend))
                                .setImageResource(R.drawable.tab_find_frd_pressed);
                        break;
                    case 2:
                        ((ImageButton) tabBtnAddress
                                .findViewById(R.id.btn_tab_bottom_contact))
                                .setImageResource(R.drawable.tab_address_pressed);
                        break;
                    case 3:
                        ((ImageButton) tabBtnSettings
                                .findViewById(R.id.btn_tab_bottom_setting))
                                .setImageResource(R.drawable.tab_settings_pressed);
                        break;
                }

                currentIndex = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

    }

    protected void resetTabBtn() {
        ((ImageButton) tabBtnWeixin.findViewById(R.id.btn_tab_bottom_weixin)).setImageResource(R.drawable.tab_weixin_normal);
        ((ImageButton) tabBtnFrd.findViewById(R.id.btn_tab_bottom_friend)).setImageResource(R.drawable.tab_find_frd_normal);
        ((ImageButton) tabBtnAddress.findViewById(R.id.btn_tab_bottom_contact)).setImageResource(R.drawable.tab_address_normal);
        ((ImageButton) tabBtnSettings.findViewById(R.id.btn_tab_bottom_setting)).setImageResource(R.drawable.tab_settings_normal);
    }

    @Override
    public void onEvent(int what, Bundle data, Object object) {
        mainHandler.sendEmptyMessage(what);
    }
}