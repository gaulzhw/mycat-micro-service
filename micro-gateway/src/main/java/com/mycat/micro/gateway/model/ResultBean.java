package com.mycat.micro.gateway.model;

/**
 * Desc:
 *
 * @date: 28/06/2017
 * @author: gaozhiwen
 */
public enum ResultBean {
    SUCCESS(200, "success"), SERVER_ERROR(502, "server error"), NOT_LOGIN(503, "not login");

    private Integer code;
    private String desc;

    ResultBean(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
