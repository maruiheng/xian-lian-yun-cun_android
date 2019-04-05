package com.xlyc.countychaincloudvillage.model.request;

public class SmsRequtst {

    /**
     * phone : 13811213215
     * countryCode : 86
     * type : 1
     */

    private String phone;
    private String countryCode;
    private String type;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
