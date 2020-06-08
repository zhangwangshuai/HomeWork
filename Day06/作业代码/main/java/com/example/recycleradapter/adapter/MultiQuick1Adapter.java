package com.example.recycleradapter.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.recycleradapter.R;
import com.example.recycleradapter.bean.InifBean;

import java.util.List;

public class MultiQuick1Adapter extends BaseMultiItemQuickAdapter<InifBean.DataBean, BaseViewHolder> {
    private Context mcontext;

    public MultiQuick1Adapter(Context contex,List<InifBean.DataBean> data) {
        super(data);
        mcontext=contex;
        addItemType(InifBean.DataBean.MULTI_1, R.layout.multi_item1);
        addItemType(InifBean.DataBean.MULTI_2, R.layout.multi_item2);
    }
    @Override
    protected void convert(BaseViewHolder helper, InifBean.DataBean item) {
        int itemType = item.getItemType();
        if (itemType==InifBean.DataBean.MULTI_1){
            Glide.with(mcontext).load(R.mipmap.ic_launcher).into((ImageView) helper.getView(R.id.img));
            helper.setText(R.id.text,item.getName());
        }else{
            helper.setText(R.id.text1,item.getName());
        }
    }
}
