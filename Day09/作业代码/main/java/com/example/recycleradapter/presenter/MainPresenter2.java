package com.example.recycleradapter.presenter;

import com.example.recycleradapter.bean.InifBean;
import com.example.recycleradapter.bean.RecyclerBean;
import com.example.recycleradapter.model.MainModel;
import com.example.recycleradapter.model.MainModel2;
import com.example.recycleradapter.view.MainView;
import com.example.recycleradapter.view.MainView2;

import java.util.List;

public class MainPresenter2 implements MainModel2.CallBack {
    private MainView2 mainView2;
    private MainModel2 mainModel2;

    public MainPresenter2(MainView2 mainView2) {
        this.mainView2 = mainView2;
        mainModel2=new MainModel2();
    }

    public void getdatas() {
        mainModel2.getdatas(this);
    }


    @Override
    public void onSuccess(List<RecyclerBean.DataBean.DatasBean> dataBeans) {
        mainView2.setData(dataBeans);
    }

    @Override
    public void onFail(String string) {
        mainView2.showToast(string);
    }
}
