package com.xlyc.countychaincloudvillage.model.request;

import java.io.Serializable;

public class LoginRequest implements Serializable {
    private String account;
    private String passwd;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "LoginRequest{" +
                "account='" + account + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
