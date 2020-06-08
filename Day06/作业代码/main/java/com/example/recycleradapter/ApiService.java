package com.example.recycleradapter;

import com.example.recycleradapter.bean.InifBean;
import com.example.recycleradapter.bean.RecyclerBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

   String BASEURL="https://www.wanandroid.com/";
    @GET("wxarticle/chapters/json")
    Observable<InifBean> getdata();

    String DATA="https://www.wanandroid.com/";
    @GET("article/listproject/0/json")
    Observable<RecyclerBean> getData();

}
