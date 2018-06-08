package com.example.u.myapplication;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Usermanage extends ListActivity implements
        OnClickListener, OnItemClickListener, OnItemLongClickListener {

    private static final String TAG = "UserTestSQLite";
    private Cursor cursor;
    private SimpleCursorAdapter adapter;
    private LinearLayout layout;
    private ListView listView;
    private List<String> list;
    private UserDao dao;
    private Users users;
    private Boolean isDeleteList = false;
    private Button deleteuser;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usermanage);
        Log.e(TAG, "onCreate");
        list = new ArrayList<String>();
        users = new Users();
        dao = new UserDao(new StudentDBHelper(this));
        listView = getListView();

        // 为按键设置监听
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
        listView.setOnCreateContextMenuListener(this);

    }

    @Override
    protected void onStart() {
        // 调用load()方法将数据库中的所有记录显示在当前页面
        super.onStart();
        load();
    }

    public void onClick(View v) {
        if (v == deleteuser) {
            // 删除数据
            if (list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    String id = list.get(i);
                    Log.e(TAG, "delete id=" + id);
                    int count = dao.deleteUserByName(id);
                }
                dao.closeDB();
                load();
            }
        }
    }

    // 创建菜单
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
    }

    // 对菜单中的按钮添加响应时间
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int item_id = item.getItemId();
        users = (Users) listView.getTag();
        Log.v(TAG, "TestSQLite++++student+" + listView.getTag() + "");
        final String usersName = users.getName();
        // Log.v(TAG, "TestSQLite+++++++id"+student_id);
        switch (item_id) {
            // 删除
            case R.id.delete:
                deleteStudentInformation(usersName);
                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }

    // 自定义一个加载数据库中的全部记录到当前页面的有参方法
    public void load(Cursor cursor) {
        adapter = new SimpleCursorAdapter(this, R.layout.user_list_item,
                cursor, new String[]{TableUser.UserColumns.Name,
                TableUser.UserColumns.Password,}, new int[]{
                R.id.user_name, R.id.user_pwd});
        listView.setAdapter(adapter);
    }
    public void load() {
        UserDataManager userdatamanager = new UserDataManager(
                Usermanage.this);
        userdatamanager.openDataBase();
        SQLiteDatabase database = userdatamanager.mDatabaseHelper.getWritableDatabase();
        cursor = database.query(TableUser.TABLE_NAME, null, null, null,
                null, null, null);
        startManagingCursor(cursor);
        adapter = new SimpleCursorAdapter(this, R.layout.user_list_item,
                cursor, new String[]{TableUser.UserColumns.Name,
                TableUser.UserColumns.Password,}, new int[]{
                R.id.user_name, R.id.user_pwd});
        listView.setAdapter(adapter);
    }

    // 全选或者取消全选
    private void checkOrClearAllCheckboxs(boolean b) {
        int childCount = listView.getChildCount();
        // Log.e(TAG, "list child size=" + childCount);
        for (int i = 0; i < childCount; i++) {
            View view = listView.getChildAt(i);
            if (view != null) {
                CheckBox box = (CheckBox) view.findViewById(R.id.cb_box);
                box.setChecked(!b);
            }
        }
    }

    // 自定义一个利用对话框形式进行数据的删除

    private void deleteStudentInformation(final String delete_id) {
        // 利用对话框的形式删除数据
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("信息删除")
                .setMessage("确定删除所选记录?")
                .setCancelable(false)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        int raws = dao.deleteUserByName(delete_id);
                        layout.setVisibility(View.GONE);
                        isDeleteList = !isDeleteList;
                        load();
                        if (raws > 0) {
                            Toast.makeText(Usermanage.this, "删除成功!",
                                    Toast.LENGTH_LONG).show();
                        } else
                            Toast.makeText(Usermanage.this, "删除失败!",
                                    Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        return false;
    }
}
