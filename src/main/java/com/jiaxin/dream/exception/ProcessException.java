package com.jiaxin.dream.exception;/**
 * @Author: bufoon
 * @Email: song.anling@zyxr.com
 * @Datetime: Created In 2018/4/27 10:49
 * @Desc: as follows.
 */

/**
 * @description: 处理异常
 * @author: gongjiaxin
 * @create: 2018-04-27 10:49
 **/
public class ProcessException extends Exception {
    private String code;
    private String desc;
    private Object data;

    public ProcessException() {
    }

    public ProcessException(String message) {
        super(message);
    }

    public ProcessException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProcessException(Throwable cause) {
        super(cause);
    }


    public ProcessException(String code, String message, Object data, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.data = data;
    }

    public ProcessException( String code, String message, String desc, Object data, Throwable cause) {
        this(code, message, data, cause);
        this.desc = desc;
    }

    public ProcessException( String code, String message) {
        this( code, message, (Object)null, (Throwable)null);
    }

    public ProcessException(String code, String message, String desc) {
        this(code, message, (Object)null, (Throwable)null);
        this.desc = desc;
    }

    protected ProcessException(Object data, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
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
