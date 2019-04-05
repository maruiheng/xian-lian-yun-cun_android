package com.xlyc.countychaincloudvillage.model.response;

import java.io.Serializable;

public class LoginResponse implements Serializable {
    /**
     * repalceFlag : 0
     * account : null
     */

    private int repalceFlag;
    private Object account;

    public int getRepalceFlag() {
        return repalceFlag;
    }

    public void setRepalceFlag(int repalceFlag) {
        this.repalceFlag = repalceFlag;
    }

    public Object getAccount() {
        return account;
    }

    public void setAccount(Object account) {
        this.account = account;
    }
}
