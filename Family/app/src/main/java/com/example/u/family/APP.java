package com.example.u.family;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

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
}@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

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