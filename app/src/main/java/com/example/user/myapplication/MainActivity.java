package com.example.user.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fmgr;
    private ViewPager viewPager;
    private Page1 page1;
    private Page2 page2;
    private Page3 page3;
    private Page4 page4;
    private Fragment[] pages;
    private String[] titles = {"主化面", "設定", "輔助", "很好看"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fmgr = getSupportFragmentManager();
        page1 = new Page1(); page2 = new Page2(); page3 = new Page3(); page4 = new Page4();
        pages = new Fragment[]{page1, page2, page3, page4};

        viewPager = (ViewPager)findViewById(R.id.viewPager);

        viewPager.setAdapter(new MyPagerAdapter(fmgr));

    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return pages[position];
        }

        @Override
        public int getCount() {
            return pages.length;
        }
    }

    public void gotoPage1(View view){
        viewPager.setCurrentItem(0);
    }
    public void gotoPage2(View view){
        viewPager.setCurrentItem(1);
    }
    public void gotoPage3(View view){
        viewPager.setCurrentItem(2);
    }
    public void gotoPage4(View view){
        viewPager.setCurrentItem(3);
    }


}
