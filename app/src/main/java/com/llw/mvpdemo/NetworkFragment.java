package com.llw.mvpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.llw.mvpdemo.bean.GankResponse;
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

    /**
     * 数据正常返回
     * @param gankResponse
     */
    @Override
    public void getListResult(GankResponse gankResponse) {

    }

    /**
     * 数据异常返回
     * @param e
     */
    @Override
    public void getListFailed(Throwable e) {

    }
}