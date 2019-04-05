package com.xlyc.countychaincloudvillage.model.request;

public class RegisterRequest {

    /**
     * account : 13999999992
     * passwd : 123456
     * smsCode : 8750
     * countryId : 1
     * countryCode : 86
     * inviteCode : 123
     */

    private String account;
    private String passwd;
    private String smsCode;
    private int countryId;
    private String countryCode;
    private String inviteCode;

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

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
}
