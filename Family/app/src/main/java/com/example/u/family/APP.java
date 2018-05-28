package com.example.u.family;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class APP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

//        SlidingMenu mSlidingMenu= (SlidingMenu) findViewById(R.id.sliding_menu);
//        //切换菜单状态
//        mSlidingMenu.toggleMenu();
//        //监听菜单状态
//        mSlidingMenu.setOnSlidingMenuStatusChangeListenter(new SlidingMenu.OnSlidingMenuStatusChangeListenter() {
//            @Override
//            public void close() {
//                Toast.makeText(MainActivity.this,"菜单关闭",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void open() {
//                Toast.makeText(MainActivity.this,"菜单打开",Toast.LENGTH_SHORT).show();
//            }
//        });


    }
}