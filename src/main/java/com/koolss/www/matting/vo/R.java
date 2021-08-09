package com.koolss.www.matting.vo;

/**
 * @ClassName R
 * @Description:
 * @Author admin
 * @Date 2021/8/9 9:29
 * @Version 1.0.0
 * @Email koolss@koolss.com
 **/
public class R<T> {
    private String msg;
    private Integer code;
    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public R(String msg, Integer code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static <T> R<T> data(String msg, Integer code, T t) {
        return new R(msg, code, t);
    }

    public static <T> R<T> data(T t) {
        return data("成功", 200, t);
    }
}
