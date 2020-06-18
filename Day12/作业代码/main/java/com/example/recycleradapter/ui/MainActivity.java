package com.example.recycleradapter.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleradapter.R;
import com.example.recycleradapter.adapter.MultiQuick1Adapter;
import com.example.recycleradapter.bean.InifBean;
import com.example.recycleradapter.presenter.MainPresenter;
import com.example.recycleradapter.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView mRecycler;
    private ArrayList<InifBean.DataBean> data;
    private MultiQuick1Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        MainPresenter mainPresenter = new MainPresenter(this);
        mainPresenter.getdata();
    }

    private void initView() {
        mRecycler = (RecyclerView) findViewById(R.id.recycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        data = new ArrayList<>();
        adapter = new MultiQuick1Adapter(this, data);
        mRecycler.setAdapter(adapter);
    }

    @Override
    public void showToast(String str) {

    }

    @Override
    public void setData(List<InifBean.DataBean> dataBeans) {
        data.addAll(dataBeans);
        adapter.notifyDataSetChanged();
    }
}
