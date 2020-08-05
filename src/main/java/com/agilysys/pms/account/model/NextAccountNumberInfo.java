package com.agilysys.pms.account.model;

import java.math.BigInteger;

public class NextAccountNumberInfo {
    private String tenantId;
    private BigInteger nextAccountNumber;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public BigInteger getNextAccountNumber() {
        return nextAccountNumber;
    }

    public void setNextAccountNumber(BigInteger nextAccountNumber) {
        this.nextAccountNumber = nextAccountNumber;
    }
}
