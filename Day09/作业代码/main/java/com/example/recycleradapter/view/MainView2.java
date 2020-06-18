package com.example.recycleradapter.view;

import com.example.recycleradapter.bean.InifBean;
import com.example.recycleradapter.bean.RecyclerBean;

import java.util.List;

public interface MainView2 {
    void showToast(String str);
    void setData(List<RecyclerBean.DataBean.DatasBean> dataBeans);
}
