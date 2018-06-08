package com.example.u.myapplication;

public class UserDao {
    private StudentDBHelper dbHelper;

    public UserDao(StudentDBHelper studentDBHelper) {
        this.dbHelper = dbHelper;
    }

    public int deleteUserByName(String name) {
        return dbHelper.getWritableDatabase().delete(TableUser.TABLE_NAME, TableUser.UserColumns.Name + "=?", new String[] { name + "" });
    }
    public void closeDB() {
        dbHelper.close();
    }
}
