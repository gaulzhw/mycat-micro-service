package com.mycat.micro.view.model;

/**
 * Desc:
 *
 * @date: 28/06/2017
 * @author: gaozhiwen
 */
public enum ResultEnum {
    SUCCESS(200, "success"), ERROR(502, "error"), NOT_LOGIN(503, "not login");

    private int code;
    private String desc;

    ResultEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
