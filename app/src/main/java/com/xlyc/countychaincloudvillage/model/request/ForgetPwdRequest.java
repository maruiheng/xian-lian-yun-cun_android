package com.xlyc.countychaincloudvillage.model.request;

public class ForgetPwdRequest {

    /**
     * account : 13999999992
     * passwd : 123456
     * smsCode : 9220
     * countyCode : 86
     */

    private String account;
    private String passwd;
    private String smsCode;
    private String countyCode;

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

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    @Override
    public String toString() {
        return "ForgetPwdRequest{" +
                "account='" + account + '\'' +
                ", passwd='" + passwd + '\'' +
                ", smsCode='" + smsCode + '\'' +
                ", countyCode='" + countyCode + '\'' +
                '}';
    }
}
