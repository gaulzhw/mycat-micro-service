package com.mycat.micro.gateway.model;

/**
 * Desc:
 *
 * @date: 28/06/2017
 * @author: gaozhiwen
 */
public enum ResultEnum {
    SUCCESS(200, "success"), SERVER_ERROR(502, "server error"), NOT_LOGIN(503, "not login"), PARAM_EMPTY(601, "param empty");

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
