package com.llw.mvpdemo;

import android.os.Bundle;

import com.llw.mvpdemo.bean.WallPaperResponse;
import com.llw.mvpdemo.contract.MainContract;
import com.llw.mvplibrary.mvp.MvpFragment;

/**
 * 需要访问网络的Fragment
 * @author lonel
 */
public class NetworkFragment extends MvpFragment<MainContract.MainPresenter> implements MainContract.IMainView {

    /**
     * 页面初始化
     * @param savedInstanceState
     */
    @Override
    public void initData(Bundle savedInstanceState) {

    }


    /**
     * 绑定布局
     * @return
     */
    @Override
    public int getLayoutId() {
        return R.layout.fragment_network;
    }

    @Override
    protected MainContract.MainPresenter createPresent() {
        return new MainContract.MainPresenter();
    }


    @Override
    public void getWallPaper(WallPaperResponse wallPaperResponse) {

    }

    @Override
    public void getWallPaperFailed(Throwable e) {

    }
}