package com.mycat.micro.view.model;

/**
 * Desc:
 *
 * @date: 29/06/2017
 * @author: gaozhiwen
 */
public class Result {
    private int code;
    private String desc;
    private Object data;

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
}
