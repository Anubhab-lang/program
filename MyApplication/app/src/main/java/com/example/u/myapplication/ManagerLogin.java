package com.example.u.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class ManagerLogin extends Activity
{
    private Button BManagerLogin;                            //登陆按钮
    private Button BManagerCancel;                          //取消按钮
    private EditText managerAccount;                        //用户名编辑
    private EditText managerPwd;                            //密码编辑
    private UserDataManager manUserDataManager;
    private SharedPreferences mlogin_sp;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(com.example.u.myapplication.R.layout.managerlogin);
        BManagerCancel = (Button) findViewById(R.id.managerlogin_btn_cancel);
        BManagerLogin = (Button) findViewById(R.id.managerlogin_btn_login);
        managerAccount = (EditText) findViewById(R.id.managerlogin_edit_account);
        managerPwd = (EditText) findViewById(R.id.managerlogin_edit_pwd);

        BManagerCancel.setOnClickListener(managerListener);
        BManagerLogin.setOnClickListener(managerListener);
        mlogin_sp = getSharedPreferences("muserInfo", 0);

    }
    OnClickListener managerListener = new OnClickListener()
    {
        public void onClick(View v)
        {
            switch (v.getId()) {
                case R.id.managerlogin_btn_login:                              //登录界面的登录按钮
                    mlogin();
                    break;
                case  R.id.managerlogin_btn_cancel:
                    exit();
                    break;
            }
        }
    };
    public void mlogin() {
        if (ismUserNameAndPwdValid()) {

            String muserName = managerAccount.getText().toString().trim();    //获取当前输入的用户名和密码信息
            String muserPwd = managerPwd.getText().toString().trim();
            SharedPreferences.Editor editor = mlogin_sp.edit();
            String truename = new String("123");
            String truepwd = new String("123");
            //Log.e(TAG, "mlogin: "+managerAccount.getText().toString()+" "+managerPwd.getText().toString() );
            boolean b1 = muserName.equals(truename);
            boolean b2 = muserPwd.equals(truepwd);
            if (b1&&b2)
            {                                             //若账号密码正确
                //保存用户名和密码

                editor.putString("USER_NAME", muserName);
                editor.putString("PASSWORD", muserPwd);
                editor.commit();
                Intent intent = new Intent(ManagerLogin.this, Manager.class);    //切换ManagerLogin Activity至User Activity
                startActivity(intent);
                finish();
                Toast.makeText(this, getString(R.string.login_success), Toast.LENGTH_SHORT).show();//登录成功提示
            }
            else {
                Toast.makeText(this, getString(R.string.login_fail),Toast.LENGTH_SHORT).show();  //登录失败提示
            }
        }
    }
    public boolean ismUserNameAndPwdValid () {
        if (managerAccount.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.account_empty),
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (managerPwd.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.pwd_empty),
                    Toast.LENGTH_SHORT).show();
            return false;
        }
            return true;
    }
    public void exit() {
        Intent intent = new Intent(ManagerLogin.this, Login.class);    //切换Login Activity至User Activity
        startActivity(intent);
        finish();
    }
}
