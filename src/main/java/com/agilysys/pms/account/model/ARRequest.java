package com.agilysys.pms.account.model;

public class ARRequest {

    private String arNumber;

    public ARRequest(){}

    public ARRequest(String arNumber){
        this.arNumber = arNumber;
    }

    public String getArNumber() {
        return arNumber;
    }

    public void setArNumber(String arNumber) {
        this.arNumber = arNumber;
    }
}
