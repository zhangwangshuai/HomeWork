package com.example.recycleradapter.adapter;

import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import com.example.recycleradapter.R;
import com.example.recycleradapter.bean.InifBean;
import com.example.recycleradapter.bean.RecyclerBean;

import java.util.List;

public class MultiQuick2Adapter extends BaseQuickAdapter<RecyclerBean.DataBean.DatasBean, BaseViewHolder> {
    private Context mcontext;

    public MultiQuick2Adapter(Context context, @Nullable List<RecyclerBean.DataBean.DatasBean> data) {
        super( data);
        //设置和type变量类型关联
        setMultiTypeDelegate(new MultiTypeDelegate<RecyclerBean.DataBean.DatasBean>() {
            @Override
            protected int getItemType(RecyclerBean.DataBean.DatasBean datasBean) {
                return datasBean.getType();
            }
        });
        //将不同的type类型和不同的布局关联
        getMultiTypeDelegate().registerItemType(RecyclerBean.DataBean.DatasBean.MULTI_1, R.layout.multi_item1);
        getMultiTypeDelegate().registerItemType(RecyclerBean.DataBean.DatasBean.MULTI_2, R.layout.multi_item2);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, RecyclerBean.DataBean.DatasBean datasBean) {
        int type = datasBean.getType();
        if (type==RecyclerBean.DataBean.DatasBean.MULTI_2){
            helper.setText(R.id.text1,datasBean.getDesc());

        }else{
            Glide.with(mContext).load(datasBean.getEnvelopePic()).into((ImageView) helper.getView(R.id.img));
            helper.setText(R.id.text,datasBean.getDesc());
        }
    }
}
