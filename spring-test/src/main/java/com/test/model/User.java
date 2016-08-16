package com.test.model;

import java.util.Date;

/**
 * Created by Administrator on 2015/11/28.
 */
public class User {
    public static final String ConstName = "constName";

    int id;
    String name;
    long no;
    Date birthday;

    public User(int id, String name){}

    static {
        System.out.println("user:" + ConstName);
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
