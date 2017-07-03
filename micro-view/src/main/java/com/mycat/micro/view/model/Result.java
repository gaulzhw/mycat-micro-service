package com.mycat.micro.view.model;

import java.io.Serializable;

/**
 * Desc:
 *
 * @date: 29/06/2017
 * @author: gaozhiwen
 */
public class Result implements Serializable {
    private static final long serialVersionUID = 8625790524979231103L;
    private int code;
    private String desc;
    private Object data;

    public Result() {
    }

    public Result(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Result(int code, String desc, Object data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                ", data=" + data +
                '}';
    }
}
