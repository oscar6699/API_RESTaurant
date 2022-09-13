package com.Restaurant.API.entity;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.persistence.*;

@Entity
@SqlResultSetMapping(name = "LoginInfo", classes = @ConstructorResult(targetClass = Login.class, columns = {
        @ColumnResult(name = "USER_ID", type = int.class),
        @ColumnResult(name = "USER_NAME", type = String.class),
        @ColumnResult(name = "USER_PASS", type = String.class)
}))
public class Login {

    @Id
    private int USER_ID;
    private String USER_NAME;
    private String USER_PASS;

    public Login(){}

    public Login(int USER_ID, String USER_NAME, String USER_PASS) {
        this.USER_ID = USER_ID;
        this.USER_NAME = USER_NAME;
        this.USER_PASS = USER_PASS;
    }

    public Login(String USER_NAME, String USER_PASS) {
        this.USER_ID = 0;
        this.USER_NAME = USER_NAME;
        this.USER_PASS = USER_PASS;
    }
    public int getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(int USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getUSER_PASS() {
        return USER_PASS;
    }

    public void setUSER_PASS(String USER_PASS) {
        this.USER_PASS = USER_PASS;
    }
}
