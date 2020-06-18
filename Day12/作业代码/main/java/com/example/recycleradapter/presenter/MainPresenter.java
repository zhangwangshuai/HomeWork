package com.example.recycleradapter.presenter;

import com.example.recycleradapter.bean.InifBean;
import com.example.recycleradapter.model.MainModel;
import com.example.recycleradapter.view.MainView;

import java.util.List;

public class MainPresenter implements MainModel.CallBack {
    private MainView mainView;
    private MainModel mainModel;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        mainModel = new MainModel();
    }


    public void getdata() {
        mainModel.getdata(this);
    }

    @Override
    public void onSuccess(List<InifBean.DataBean> dataBeans) {
        mainView.setData(dataBeans);
    }

    @Override
    public void onFail(String string) {
        mainView.showToast(string);
    }
}
