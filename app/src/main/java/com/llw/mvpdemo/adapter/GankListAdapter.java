package com.llw.mvpdemo.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.llw.mvpdemo.R;
import com.llw.mvpdemo.bean.GankResponse;

import java.util.List;

/**
 * 列表适配器
 *
 * @author llw
 */
public class GankListAdapter extends BaseQuickAdapter<GankResponse.DataBean, BaseViewHolder> {

    public GankListAdapter(int layoutResId, @Nullable List<GankResponse.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GankResponse.DataBean item) {
        String imgUrl = item.getImages().get(0);

        Glide.with(mContext).load((imgUrl != null && !imgUrl.isEmpty()) ? imgUrl : "").into((ImageView) helper.getView(R.id.image));
        helper.setText(R.id.desc, item.getDesc());
    }
}
