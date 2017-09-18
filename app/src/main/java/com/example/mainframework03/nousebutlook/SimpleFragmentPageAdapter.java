package com.example.mainframework03.nousebutlook;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.SparseArrayCompat;
import android.view.ViewGroup;
import com.example.mainframework03.base.BaseFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * FragmentPagerAdapter扩展
 *
 * @author Leon(黄长亮)
 * @date 2017/5/18.
 */
public class SimpleFragmentPageAdapter extends FragmentPagerAdapter {

    private SparseArrayCompat<BaseFragment> mCachesFragment; // 设置新的Fragment也会用到
    private FragmentManager mFragmentManager;
    private List<String> mTags;
    private String[] mTitles;
    private Bundle mBundle;


    public SimpleFragmentPageAdapter(FragmentManager fm, SparseArrayCompat<BaseFragment> cachesFragment) {
        this(fm, cachesFragment, "");
    }

    public SimpleFragmentPageAdapter(FragmentManager fm, SparseArrayCompat<BaseFragment> cachesFragment, Bundle bundle) {
        this(fm, cachesFragment, bundle, "");
    }

    public SimpleFragmentPageAdapter(FragmentManager fm, SparseArrayCompat<BaseFragment> cachesFragment, String... titles) {
        this(fm, cachesFragment, null, titles);
    }

    public SimpleFragmentPageAdapter(FragmentManager fm, SparseArrayCompat<BaseFragment> cachesFragment, Bundle bundle, String... titles) {
        super(fm);
        this.mTags = new ArrayList<String>();
        this.mFragmentManager = fm;
        this.mCachesFragment = cachesFragment; // 保存
        this.mBundle = bundle;
        mTitles = titles;
    }

    /*
     * 设置新的 Fragment
     */
    public void setNewFragments(SparseArrayCompat<BaseFragment> cachesFragment) {
        if (this.mTags != null) {
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            for (int i = 0; i < mTags.size(); i++) { // 移除所有 Fragment
                fragmentTransaction.remove(mFragmentManager.findFragmentByTag(mTags.get(i)));
            }
            fragmentTransaction.commit();
            mFragmentManager.executePendingTransactions();
            mTags.clear(); // 清除所有标签
        }
        this.mCachesFragment = cachesFragment; // mCachesFragment 是集合
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = null;
        if (mBundle != null) {
            bundle = (Bundle) mBundle.clone();
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("position", position);
        mCachesFragment.get(position).setArguments(bundle);
        return mCachesFragment.get(position);
    }

    @Override
    public int getCount() {
        return mCachesFragment.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        mTags.add(makeFragmentName(container.getId(), getItemId(position)));
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        this.mFragmentManager.beginTransaction().show(fragment).commit();
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Fragment fragment = mCachesFragment.get(position);
        mFragmentManager.beginTransaction().hide(fragment).commit();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    //此方法用来显示tab上的名字，不写TabLayout上是空白的
    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitles.length < mCachesFragment.size()) {
            return "";
        }
        return mTitles[position % mTitles.length];
    }

    private static String makeFragmentName(int viewId, long id) {
        return "android:switcher:" + viewId + ":" + id;
    }
}
