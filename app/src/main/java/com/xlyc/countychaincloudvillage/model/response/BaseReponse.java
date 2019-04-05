package com.xlyc.countychaincloudvillage.model.response;

public class BaseReponse<T> {
    //{"code":0,"data":{"repalceFlag":0,"account":null},"message":"成功"}
    public int code;
    public String message;
    public T data;
    public BaseReponse(int code, String _message, T data) {
        this.code = code;
        this.message = _message;
        this.data = data;
    }

}

