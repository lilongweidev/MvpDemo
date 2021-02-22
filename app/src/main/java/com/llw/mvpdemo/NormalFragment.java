package com.llw.mvpdemo;

import android.os.Bundle;

import com.llw.mvplibrary.base.BaseFragment;

/**
 * 普通Fragment
 * @author lonel
 */
public class NormalFragment extends BaseFragment {

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_normal;
    }
}