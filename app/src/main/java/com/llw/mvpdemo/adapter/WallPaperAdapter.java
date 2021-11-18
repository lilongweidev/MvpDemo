package com.llw.mvpdemo.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.llw.mvpdemo.R;
import com.llw.mvpdemo.bean.WallPaperResponse;

import java.util.List;

/**
 * 壁纸适配器
 * @author llw
 */
public class WallPaperAdapter extends BaseQuickAdapter<WallPaperResponse.ResBean.VerticalBean, BaseViewHolder> {

    public WallPaperAdapter(List<WallPaperResponse.ResBean.VerticalBean> data) {
        super(R.layout.item_wallpaper, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WallPaperResponse.ResBean.VerticalBean item) {
        ImageView imageView = helper.getView(R.id.image);
        Glide.with(mContext).load(item.getImg()).into(imageView);
    }
}
