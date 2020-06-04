package com.example.text3;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar mTool;
    private ViewPager mVp;
    private TabLayout mTab;
    private LinearLayout mLl;
    private NavigationView mNv;
    private DrawerLayout mDl;
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTool = (Toolbar) findViewById(R.id.tool);
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);
        mLl = (LinearLayout) findViewById(R.id.ll);
        mNv = (NavigationView) findViewById(R.id.nv);
        mDl = (DrawerLayout) findViewById(R.id.dl);
        mText = (TextView) findViewById(R.id.text);

        mTool.setTitle("消息");
        setSupportActionBar(mTool);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDl, mTool, R.string.app_name, R.string.app_name);
        toggle.syncState();
        mDl.addDrawerListener(toggle);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new InformationFragment());
        fragments.add(new LinkmanFragment());
        fragments.add(new DynamicFragment());
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        mVp.setAdapter(adapter);
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText("消息").setIcon(R.drawable.a);
        mTab.getTabAt(1).setText("联系人").setIcon(R.drawable.b);
        mTab.getTabAt(2).setText("动态").setIcon(R.drawable.c);

        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 0) {
                    mTool.setTitle("消息");
                } else if (position == 1) {
                    mTool.setTitle("联系人");
                } else if (position == 2) {
                    mTool.setTitle("动态");
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
