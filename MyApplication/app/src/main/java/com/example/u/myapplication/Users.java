package com.example.u.myapplication;

import java.io.Serializable;

public class Users implements Serializable {
    private String name;
    private String password;
    public Users(){
        super();
    }
    public Users(String name, String password) {
        super();
        this.name = name;
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
