package com.llw.mvpdemo;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.llw.mvpdemo.adapter.GankListAdapter;
import com.llw.mvpdemo.bean.GankResponse;
import com.llw.mvpdemo.contract.MainContract;
import com.llw.mvplibrary.mvp.MvpActivity;
import com.llw.mvplibrary.network.utils.KLog;
import java.util.ArrayList;
import java.util.List;


/**
 * @author llw
 */
public class MainActivity extends MvpActivity<MainContract.MainPresenter> implements MainContract.IMainView {


    private RecyclerView rv;

    private static final String TAG = "MainActivity";

    private List<GankResponse.DataBean> mList = new ArrayList<>();
    private GankListAdapter mAdapter;

    @Override
    public void initData(Bundle savedInstanceState) {
        //显示加载弹窗
        showLoadingDialog();
        //初始化列表
        initList();
    }

    /**
     * 初始化列表
     */
    private void initList() {
        rv = findViewById(R.id.rv);
        //配置rv
        mAdapter = new GankListAdapter(R.layout.item_list, mList);
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(mAdapter);

        //请求列表数据
        mPresenter.getGankList();
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainContract.MainPresenter createPresenter() {
        return new MainContract.MainPresenter();
    }

    /**
     * 获取列表数据返回
     *
     * @param gankResponse
     */
    @Override
    public void getListResult(GankResponse gankResponse) {
        if (gankResponse.getData() != null && gankResponse.getData().size() > 0) {
            mList.clear();
            mList.addAll(gankResponse.getData());
            mAdapter.notifyDataSetChanged();
            hideLoadingDialog();
        } else {
            showMsg("数据为空");
            hideLoadingDialog();
        }
    }

    /**
     * 获取列表数据异常
     *
     * @param e
     */
    @Override
    public void getListFailed(Throwable e) {
        KLog.e(TAG, e.toString());
        showMsg("获取列表数据异常，具体日志信息请查看日志");
        hideLoadingDialog();
    }


}
