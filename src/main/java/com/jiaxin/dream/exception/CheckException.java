package com.jiaxin.dream.exception;/**
 * @Author: bufoon
 * @Email: song.anling@zyxr.com
 * @Datetime: Created In 2018/4/27 10:49
 * @Desc: as follows.
 */

/**
 * @description: 校验类异常
 * @author: gongjiaxin
 * @create: 2018-04-27 10:49
 **/
public class CheckException extends Exception {
    private String code;
    private String desc;
    private Object data;

    public CheckException() {
    }

    public CheckException(String message) {
        super(message);
        this.desc = message;
    }

    public CheckException(String message, Throwable cause) {
        super(message, cause);
        this.desc = message;
    }

    public CheckException(Throwable cause) {
        super(cause);
    }


    public CheckException(String code, String message, Object data, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.data = data;
        this.desc = message;
    }

    public CheckException(String code, String message, String desc, Object data, Throwable cause) {
        this(code, message, data, cause);
        this.desc = desc;
    }

    public CheckException(String code, String message) {
        this( code, message, (Object)null, (Throwable)null);
        this.desc = message;
    }

    public CheckException(String code, String message, String desc) {
        this(code, message, (Object)null, (Throwable)null);
        this.desc = desc;
    }

    protected CheckException(Object data, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.data = data;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
