package com.llw.mvpdemo.contract;

import android.annotation.SuppressLint;

import com.llw.mvpdemo.api.ApiService;
import com.llw.mvpdemo.bean.GankResponse;
import com.llw.mvplibrary.base.BasePresenter;
import com.llw.mvplibrary.base.BaseView;
import com.llw.mvplibrary.network.NetworkApi;
import com.llw.mvplibrary.network.observer.BaseObserver;

/**
 * 将V与M订阅起来
 * @author llw
 */
public class MainContract {

    public static class MainPresenter extends BasePresenter<IMainView> {

        @SuppressLint("CheckResult")
        public void getGankList(){
            ApiService service  = NetworkApi.createService(ApiService.class);
            service.getList().compose(NetworkApi.applySchedulers(new BaseObserver<GankResponse>() {
                @Override
                public void onSuccess(GankResponse gankResponse) {
                    if (getView() != null) {
                        getView().getListResult(gankResponse);
                    }
                }

                @Override
                public void onFailure(Throwable e) {
                    if (getView() != null) {
                        getView().getListFailed(e);
                    }
                }
            }));
        }
    }

    public interface IMainView extends BaseView {
        //返回列表结果
        void getListResult(GankResponse gankResponse);
        //获取列表失败返回
        void getListFailed(Throwable e);
    }
}
