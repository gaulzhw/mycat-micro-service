package com.mycat.micro.gateway.model;

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

    public Result(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.desc = resultEnum.getDesc();
    }

    public Result(ResultEnum resultEnum, Object data) {
        this.code = resultEnum.getCode();
        this.desc = resultEnum.getDesc();
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
}
