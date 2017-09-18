package com.example.mainframework03.base;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.example.mainframework03.base.BaseFragment;
import com.example.mainframework03.other.Common;

/*
 * 统一添加生命周期的打印
 */
public class MyBaseFragment extends BaseFragment {

    protected String getLogTag() {
        return this.getClass().getName();
    }

    public MyBaseFragment() {
        super();
        Log.i(Common.TAG, getLogTag() + ":this()");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(Common.TAG, getLogTag() + ".onActivityCreated(Bundle savedInstanceState)");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(Common.TAG, getLogTag() + ".onActivityResult(int requestCode, int resultCode, Intent data)");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i(Common.TAG, getLogTag() + ":onAttach(Activity activity)");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i(Common.TAG, getLogTag() + ".onConfigurationChanged(Configuration newConfig)");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Log.i(Common.TAG, getLogTag() + ":onContextItemSelected(MenuItem item)");
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(Common.TAG, getLogTag() + ":onCreate(Bundle savedInstanceState)");
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        Log.i(Common.TAG, getLogTag() + ".onCreateAnimation(int transit, boolean enter, int nextAnim)");
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        Log.i(Common.TAG, getLogTag() + ".onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        Log.i(Common.TAG, getLogTag() + ".onCreateOptionsMenu(Menu menu, MenuInflater inflater)");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(Common.TAG, getLogTag() + ".onCreateView(LayoutInflater inflater, ViewGroup container,	Bundle savedInstanceState)");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(Common.TAG, getLogTag() + ":onDestroy()");
    }

    @Override
    public void onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu();
        Log.i(Common.TAG, getLogTag() + ":onDestroyOptionsMenu()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(Common.TAG, getLogTag() + ":onDestroyView()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(Common.TAG, getLogTag() + ":onDetach()");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.i(Common.TAG, getLogTag() + ":onHiddenChanged(boolean hidden)");
    }

    @Override
    public void onInflate(Activity activity, AttributeSet attrs,
                          Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        Log.i(Common.TAG, getLogTag() + ".onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState)");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.i(Common.TAG, getLogTag() + ":onLowMemory()");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i(Common.TAG, getLogTag() + ":onOptionsItemSelected(MenuItem item)");
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
        Log.i(Common.TAG, getLogTag() + ":onOptionsMenuClosed(Menu menu)");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(Common.TAG, getLogTag() + ":onPause()");
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        Log.i(Common.TAG, getLogTag() + ":onPrepareOptionsMenu(Menu menu)");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(Common.TAG, getLogTag() + ":onResume()");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(Common.TAG, getLogTag() + ":onSaveInstanceState(Bundle outState)");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(Common.TAG, getLogTag() + ":onStart()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(Common.TAG, getLogTag() + ":onStop()");
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(Common.TAG, getLogTag() + ".onViewCreated(View view, Bundle savedInstanceState)");
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i(Common.TAG, getLogTag() + ".onViewStateRestored(Bundle savedInstanceState)");
    }

}