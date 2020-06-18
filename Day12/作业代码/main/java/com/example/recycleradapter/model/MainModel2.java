package com.example.recycleradapter.model;

import com.example.recycleradapter.ApiService;
import com.example.recycleradapter.bean.InifBean;
import com.example.recycleradapter.bean.RecyclerBean;
import com.example.recycleradapter.presenter.MainPresenter2;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel2 {
    public void getdatas(final CallBack callBack) {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.DATA)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = build.create(ApiService.class);
        Observable<RecyclerBean> data = apiService.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RecyclerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RecyclerBean recyclerBean) {
                        callBack.onSuccess(recyclerBean.getData().getDatas());
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }



    public interface CallBack{
        void onSuccess(List<RecyclerBean.DataBean.DatasBean> dataBeans);
        void onFail(String string);
    }
}
