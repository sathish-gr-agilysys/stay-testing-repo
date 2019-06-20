/*
 *
 *  *  (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 *
 */

package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

import com.agilysys.pms.account.model.external.Reservation;
import com.google.common.collect.Lists;

public class AccountClosableInfo {
    private String tenantId;

    private String propertyId;

    private String accountId;

    private String accountType;

    private String accountStatus;

    private BigDecimal accountBalance;

    private boolean closable;

    private List<Reservation> reservations = Lists.newLinkedList();

    private List<String> nonClosableReasons = Lists.newLinkedList();

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public boolean isClosable() {
        return closable;
    }

    public void setClosable(boolean closable) {
        this.closable = closable;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public List<String> getNonClosableReasons() {
        return nonClosableReasons;
    }
}
