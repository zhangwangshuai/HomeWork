package com.example.recycleradapter.ui;

import android.icu.text.Transliterator;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleradapter.R;
import com.example.recycleradapter.adapter.MultiQuick1Adapter;
import com.example.recycleradapter.adapter.MultiQuick2Adapter;
import com.example.recycleradapter.bean.InifBean;
import com.example.recycleradapter.bean.RecyclerBean;
import com.example.recycleradapter.presenter.MainPresenter;
import com.example.recycleradapter.presenter.MainPresenter2;
import com.example.recycleradapter.view.MainView2;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements MainView2 {
    private RecyclerView mRecycler;
    private ArrayList<RecyclerBean.DataBean.DatasBean> data;
    private MultiQuick2Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        MainPresenter2 mainPresenter2 = new MainPresenter2(this);
        mainPresenter2.getdatas();
    }

    private void initView() {
        mRecycler = (RecyclerView) findViewById(R.id.recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        data = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            RecyclerBean.DataBean.DatasBean datasBean = data.get(i);
            if (i == 0) {
                datasBean.setType(RecyclerBean.DataBean.DatasBean.MULTI_1);
            } else{
                datasBean.setType(RecyclerBean.DataBean.DatasBean.MULTI_2);
            }
        }
        adapter = new MultiQuick2Adapter(this, data);
        mRecycler.setAdapter(adapter);
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(List<RecyclerBean.DataBean.DatasBean> dataBeans) {
        data.addAll(dataBeans);
        adapter.notifyDataSetChanged();
    }
}