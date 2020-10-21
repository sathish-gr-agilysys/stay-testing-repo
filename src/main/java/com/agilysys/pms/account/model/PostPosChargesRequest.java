/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.LocalDate;

public class PostPosChargesRequest {
    private List<PosCharge> charges;
    private boolean distributed;
    private String name;
    private LocalDate postingDate;
    private String accountId;
    private boolean houseAccount;
    private BigDecimal totalAmount;
    private String outletName;
    private String mealPeriodName;

    public List<PosCharge> getCharges() {
        return charges;
    }

    public void setCharges(List<PosCharge> charges) {
        this.charges = charges;
    }

    public boolean isDistributed() {
        return distributed;
    }

    public void setDistributed(boolean distributed) {
        this.distributed = distributed;
    }

    public LocalDate getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(LocalDate postingDate) {
        this.postingDate = postingDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public boolean isHouseAccount() {
        return houseAccount;
    }

    public void setHouseAccount(boolean houseAccount) {
        this.houseAccount = houseAccount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getMealPeriodName() {
        return mealPeriodName;
    }

    public void setMealPeriodName(String mealPeriodName) {
        this.mealPeriodName = mealPeriodName;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }
}