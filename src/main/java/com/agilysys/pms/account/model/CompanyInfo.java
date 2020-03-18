/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

public class CompanyInfo {
    private String id;
    private String companyName;
    private String accountId;
    private BigDecimal creditLimit;
    private String accountNumber;
    private String contactId;

    public CompanyInfo() {}

    public CompanyInfo(String id, String companyName, String accountId, BigDecimal creditLimit, String accountNumber,
          String contactId) {
        this.id = id;
        this.companyName = companyName;
        this.accountId = accountId;
        this.creditLimit = creditLimit;
        this.accountNumber = accountNumber;
        this.contactId = contactId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }
}
