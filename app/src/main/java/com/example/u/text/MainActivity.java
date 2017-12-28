package com.example.u.text;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private NotificationManager manger;
    private Intent service;
    public static final int TYPE_Progress = 2;
    public static final int TYPE_Normal = 1;
    private TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         btn1 = (Button)findViewById(R.id.button1);
        btn1.setOnClickListener(lisenter);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");//初始为空，会传入空值
        textview = (TextView)findViewById(R.id.textView123);
        textview.setText(name);
    }
    private View.OnClickListener lisenter = new View.OnClickListener()
    {//侦听器
        @Override
        public void onClick(View view) {
            Button button = (Button) view;
            try
            {
                switch (button.getId())//获取点击按钮的ID，通过ID选择对应的选项执行
                {
                    case R.id.button1://如果点击了按钮：“1”
                    {
                        Intent intent = new Intent(MainActivity.this,duihuakuang.class);
                        break;
                    }
                    default:
                        break;
                }
            }catch(Exception e){}
        }
    };
}
