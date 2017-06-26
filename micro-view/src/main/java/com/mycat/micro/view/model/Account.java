package com.mycat.micro.view.model;

import java.io.Serializable;

/**
 * Desc:
 *
 * @date: 25/06/2017
 * @author: gaozhiwen
 */
public class Account implements Serializable {
    private static final long serialVersionUID = -229511409182036386L;
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
