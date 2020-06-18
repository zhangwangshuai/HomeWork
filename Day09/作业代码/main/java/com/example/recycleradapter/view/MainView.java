package com.example.recycleradapter.view;

import com.example.recycleradapter.bean.InifBean;

import java.util.List;

public interface MainView {
    void showToast(String str);
    void setData(List<InifBean.DataBean> dataBeans);
}
