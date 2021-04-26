package com.llw.mvpdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.ViewGroup;

import com.llw.mvplibrary.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends BaseActivity {

    List<Fragment> fragmentList = new ArrayList<>();
    MainFragmentPagerAdapter adapter;
    ViewPager viewPager;

    public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
        List<Fragment> mFragmentList;
        public MainFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            mFragmentList=list;
        }

        @Override
        public Fragment getItem(int i) {
            return mFragmentList.get(i);
        }

        @Override
        public int getCount() {
            return mFragmentList!=null?mFragmentList.size():0;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        }
    }



    @Override
    public void initData(Bundle savedInstanceState) {
        viewPager = findViewById(R.id.vp);
        initViewPager();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    private void initViewPager() {
        //添加碎片
        fragmentList.add(new NormalFragment());
        fragmentList.add(new NetworkFragment());

        adapter = new MainFragmentPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);
    }

}
