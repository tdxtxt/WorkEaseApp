package com.wanny.workease.system.framework_mvpbasic;

/**
 * 文件名： BaseBean
 * 功能：
 * 作者： wanny
 * 时间： 9:46 2016/8/15
 */
public class BaseBean<T> {
    private boolean success;
    private String msg;
    private T data;

//      "Status": true,
//              "Code": 0,
//              "Message": "操作成功",
//              "Result": "{"Name":"wanny","Phone":"13677659892","Token":"2e1530a2"}"
//


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
