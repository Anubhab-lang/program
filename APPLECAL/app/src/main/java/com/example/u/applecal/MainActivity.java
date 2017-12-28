package com.example.u.applecal;

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
    //变量定义
    private EditText editText;          //输入框：用于输入数字
    private String operator;            //操作符：记录 + - * / 符号
    private double n1 , n2 ,Result;     //操作数：操作符两端的数字，n1为左操作数，n2为右操作数。
    private TextView textView;          //文本框：显示计算过程和计算结果
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;   //按钮：十个数字
    private Button btnPlus,btnMinus,btnMultiply,btnDivide;              //按钮：加减乘除
    private Button btnPoint,btnEqual,btnClear,btnfuhao,btnbaifenbi;                          //按钮：小数点，等号，清空
    private NotificationManager manger;
    private Intent service;
    public static final int TYPE_Progress = 2;
    public static final int TYPE_Normal = 1;

    //////////////////////////////////////////////////////////
    //选项菜单
    //////////////////////////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "复制");
        menu.add(0, 2, 0, "粘贴");
        menu.add(0, 3, 0, "剪切");
        return true;
    }

    //菜单添加点击事件,需要重写onOptionsItemSelected（）方法。
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(MainActivity.this, "我是计算机学院", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(MainActivity.this, "我是电信学院", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(MainActivity.this, "我是。。。", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(MainActivity.this, "I am 。。。", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    ////////////////////////////////////////////////////////////////
    //上下文菜单
    //////////////////////////////////////////////////////////
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v == textView) {
            menu.add(0, 1, 0, "我是菜单1");
            menu.add(0, 2, 0, "我是菜单2");
            menu.add(0, 3, 0, "我是菜单3");
        }

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(MainActivity.this, "菜单1", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(MainActivity.this, "菜单2", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(MainActivity.this, "菜单3", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }

    private View.OnClickListener lisenter = new View.OnClickListener() {//侦听器
        @Override
        public void onClick(View view) {//点击事件
            editText=(EditText) findViewById(R.id.editviewdavid);
            editText.setCursorVisible(false);//隐藏输入框光标
            String str;
            Button button = (Button)view;   //把点击获得的id信息传递给button
            DecimalFormat MyFormat = new DecimalFormat("###.##");//控制Double转为String的格式
            try{
                switch(button.getId())//获取点击按钮的ID，通过ID选择对应的选项执行
                {
                    case R.id.button1://如果点击了按钮：“1”
                    {
                        editText.setText(editText.getText().toString() + 1);//输入框末尾，添加一个“1”
                        break;
                    }
                    case R.id.button2://2
                    {
                        editText.setText(editText.getText().toString() + 2);
                        break;
                    }
                    case R.id.button3://3
                    {
                        editText.setText(editText.getText().toString() + 3);
                        break;
                    }
                    case R.id.button4://4
                    {
                        editText.setText(editText.getText().toString() + + 4);
                        break;
                    }
                    case R.id.button5://5
                    {
                        editText.setText(editText.getText().toString() + 5);
                        break;
                    }
                    case R.id.button6://6
                    {
                        editText.setText(editText.getText().toString() +  6);
                        break;
                    }
                    case R.id.button7://7
                    {
                        editText.setText(editText.getText().toString() +  7);
                        break;
                    }
                    case R.id.button8://8
                    {
                        editText.setText(editText.getText().toString() +   8);
                        break;
                    }
                    case R.id.button9://9
                    {
                        editText.setText(editText.getText().toString() +  9);
                        break;
                    }
                    case R.id.button0://0
                    {
                        str = editText.getText().toString();
                        //此处可以考虑添加代码，限制用户输入00,000等 2017.6.15
                        editText.setText(str + 0);
                        break;
                    }
                    case R.id.buttonClear://Clear
                    {
                        editText.setText("");
                        Result = 0;
                        break;
                    }
                    case R.id.buttonbaifenbi:
                    {
                        str = editText.getText().toString();
                        n1 = Double.parseDouble(str);
                        editText.setText(n1 * 100 + "");
                        break;
                    }
                    case R.id.buttonPoint://.
                    {
                        str = editText.getText().toString();
                        if(str.indexOf(".") != -1) //判断字符串中是否已包含小数点，如果有，就什么也不做
                        {

                        }
                        else //如果没有小数点
                        {
                            if(str.equals("0"))//如果开始为0
                                editText.setText(("0" + ".").toString());
                            else if(str.equals(""))//如果初时显示为空，就什么也不做
                            {}
                            else
                                editText.setText(str + ".");
                        }
                        break;
                    }
                    case R.id.buttonPlus://操作符+
                    {
                        str = editText.getText().toString();
                        n1 = Double.parseDouble(str);
                        operator = "+";
                        editText.setText("");
                        break;
                    }
                    case R.id.buttonMinus://操作符-
                    {
                        str = editText.getText().toString();
                        n1 = Double.parseDouble(str);
                        operator = "-";
                        editText.setText("");
                        break;
                    }
                    case R.id.buttonMultiply://操作符*
                    {
                        str = editText.getText().toString();
                        n1 = Double.parseDouble(str);
                        operator = "*";
                        editText.setText("");
                        break;
                    }
                    case R.id.buttonfuhao:
                    {
                        str = editText.getText().toString();
                        n1 = Double.parseDouble(str);
                        editText.setText(n1 * (-1)+"");
                    }
                    case R.id.buttonDivide://操作符 /
                    {
                        str = editText.getText().toString();
                        n1 = Double.parseDouble(str);
                        operator = "/";
                        editText.setText("");
                        break;
                    }
                    case R.id.buttonEqual://操作符=
                    {
                        simpleNotify();
                        if(operator == "+")
                        {
                            str = editText.getText().toString();
                            n2 = Double.parseDouble(str);
                            Result = n1 + n2;
                            editText.setText(MyFormat.format(Result)+"");
                        }
                        else if(editText.getText().toString() == "666")
                        {
                            simpleNotify();
                        }
                        else if(operator == "-")
                        {
                            str = editText.getText().toString();
                            n2 = Double.parseDouble(str);
                            Result = n1 - n2;
                            editText.setText(MyFormat.format(Result)+"");
                        }
                        else if(operator == "*")
                        {
                            str = editText.getText().toString();
                            n2 = Double.parseDouble(str);
                            Result = n1 * n2;
                            editText.setText(MyFormat.format(Result)+"");
                        }
                        else if(operator == "/")
                        {
                            str = editText.getText().toString();
                            n2 = Double.parseDouble(str);
                            if(n2 == 0)
                            {
                                editText.setText("除数不能为0");
                                break;
                            }
                            else
                            {
                                Result = n1 / n2;
                                editText.setText(MyFormat.format(Result)+"");
                            }
                        }
                        break;
                    }
                    default:
                        break;

                }
            }catch(Exception e){}
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取按钮的id
        textView =(TextView)findViewById(R.id.david);
        registerForContextMenu(textView);//注册事件
        manger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        service = new Intent(this,DownloadService.class);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btn0 = (Button) findViewById(R.id.button0);
        btnPlus = (Button) findViewById(R.id.buttonPlus);
        btnMinus = (Button) findViewById(R.id.buttonMinus);
        btnMultiply = (Button) findViewById(R.id.buttonMultiply);
        btnDivide = (Button) findViewById(R.id.buttonDivide);
        btnPoint = (Button) findViewById(R.id.buttonPoint);
        btnEqual = (Button) findViewById(R.id.buttonEqual);
        btnClear = (Button) findViewById(R.id.buttonClear);
        btnfuhao = (Button) findViewById(R.id.buttonfuhao);
        btnbaifenbi = (Button) findViewById(R.id.buttonbaifenbi);
        //为按钮添加监听器
        btn1.setOnClickListener(lisenter);
        btn2.setOnClickListener(lisenter);
        btn3.setOnClickListener(lisenter);
        btn4.setOnClickListener(lisenter);
        btn5.setOnClickListener(lisenter);
        btn6.setOnClickListener(lisenter);
        btn7.setOnClickListener(lisenter);
        btn8.setOnClickListener(lisenter);
        btn9.setOnClickListener(lisenter);
        btn0.setOnClickListener(lisenter);
        btnPlus.setOnClickListener(lisenter);
        btnMinus.setOnClickListener(lisenter);
        btnMultiply.setOnClickListener(lisenter);
        btnDivide.setOnClickListener(lisenter);
        btnPoint.setOnClickListener(lisenter);
        btnEqual.setOnClickListener(lisenter);
        btnClear.setOnClickListener(lisenter);
        btnfuhao.setOnClickListener(lisenter);
        btnbaifenbi.setOnClickListener(lisenter);
    }
    private void simpleNotify(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        //Ticker是状态栏显示的提示
        builder.setTicker("简单Notification");
        //第一行内容  通常作为通知栏标题
        builder.setContentTitle("标题");
        //第二行内容 通常是通知正文
        builder.setContentText("通知内容");
        //第三行内容 通常是内容摘要什么的 在低版本机器上不一定显示
        builder.setSubText("这里显示的是通知第三行内容！");
        //ContentInfo 在通知的右侧 时间的下面 用来展示一些其他信息
        //builder.setContentInfo("2");
        builder.setAutoCancel(true);
        builder.setNumber(2);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.deep_gray));
        Intent intent = new Intent(this,SettingsActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this,1,intent,0);
        builder.setContentIntent(pIntent);
        //设置震动
        //long[] vibrate = {100,200,100,200};
        //builder.setVibrate(vibrate);

        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        Notification notification = builder.build();
        manger.notify(TYPE_Normal,notification);
    }
}