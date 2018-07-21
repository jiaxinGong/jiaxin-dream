package com.jiaxin.dream.model;/**
 * @Author: jiaxin Gong
 * @Email: gong.jiaxin@szrttx.com
 * @Datetime: Created In 2018/4/27 14:41
 * @Desc: as follows.
 */

import java.io.Serializable;

/**
 * @description: 统一接口返回
 * @author: gongjiaxin
 * @create: 2018-04-27 14:41
 **/
public class ResultBean<T> implements Serializable {
    public static final int SUCCESS = 0;

    public static final int FAIL = 1;

    public static final int NO_PERMISSION = 2;

    private String msg = "success";

    private int code = SUCCESS;

    private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        super();
        this.data = data;
    }
    public ResultBean(String msg) {
        super();
        this.code = FAIL;
        this.msg = msg;
    }

    public ResultBean(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = FAIL;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
