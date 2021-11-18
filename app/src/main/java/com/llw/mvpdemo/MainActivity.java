package com.llw.mvpdemo;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.llw.mvpdemo.adapter.WallPaperAdapter;
import com.llw.mvpdemo.bean.WallPaperResponse;
import com.llw.mvpdemo.contract.MainContract;
import com.llw.mvplibrary.mvp.MvpActivity;
import com.llw.mvplibrary.network.utils.KLog;
import java.util.ArrayList;
import java.util.List;


/**
 * @author llw
 */
public class MainActivity extends MvpActivity<MainContract.MainPresenter> implements MainContract.IMainView {


    private static final String TAG = "MainActivity";
    private final List<WallPaperResponse.ResBean.VerticalBean> mList = new ArrayList<>();
    private WallPaperAdapter mAdapter;

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
        RecyclerView rv = findViewById(R.id.rv);
        //配置rv
        mAdapter = new WallPaperAdapter(mList);
        rv.setLayoutManager(new GridLayoutManager(context,2));
        rv.setAdapter(mAdapter);

        //请求列表数据
        mPresenter.getWallPaper();
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
     * 获取壁纸返回
     *
     * @param wallPaperResponse
     */
    @Override
    public void getWallPaper(WallPaperResponse wallPaperResponse) {
        List<WallPaperResponse.ResBean.VerticalBean> vertical = wallPaperResponse.getRes().getVertical();
        if (vertical != null && vertical.size() > 0) {
            mList.clear();
            mList.addAll(vertical);
            mAdapter.notifyDataSetChanged();
        } else {
            showMsg("数据为空");
        }
        hideLoadingDialog();
    }

    /**
     * 获取列表数据异常
     *
     * @param e
     */
    @Override
    public void getWallPaperFailed(Throwable e) {
        KLog.e(TAG,e.toString());
        showMsg("获取列表数据异常，具体日志信息请查看日志");
        hideLoadingDialog();
    }
}
