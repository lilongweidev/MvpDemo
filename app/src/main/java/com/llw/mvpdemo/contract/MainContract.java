package com.llw.mvpdemo.contract;

import android.annotation.SuppressLint;

import com.llw.mvpdemo.api.ApiService;
import com.llw.mvpdemo.bean.WallPaperResponse;
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
        public void getWallPaper(){
            ApiService service  = NetworkApi.createService(ApiService.class);
            service.getWallPaper().compose(NetworkApi.applySchedulers(new BaseObserver<WallPaperResponse>() {
                @Override
                public void onSuccess(WallPaperResponse wallPaperResponse) {
                    if (getView() != null) {
                        getView().getWallPaper(wallPaperResponse);
                    }
                }

                @Override
                public void onFailure(Throwable e) {
                    if (getView() != null) {
                        getView().getWallPaperFailed(e);
                    }
                }
            }));
        }
    }

    public interface IMainView extends BaseView {
        void getWallPaper(WallPaperResponse wallPaperResponse);
        //获取列表失败返回
        void getWallPaperFailed(Throwable e);
    }
}
