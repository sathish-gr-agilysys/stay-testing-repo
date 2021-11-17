/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

public class PostPosCreditRequest extends PostCreditsRequestBase<PosCredit>{
    private BigDecimal totalAmount;
    private String name;
    private boolean houseAccountPOS;
    private String outletId;

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutletId() {
        return outletId;
    }

    public void setOutletId(String outletId) {
        this.outletId = outletId;
    }

    public boolean isHouseAccountPOS() {
        return houseAccountPOS;
    }

    public void setHouseAccountPOS(boolean houseAccountPOS) {
        this.houseAccountPOS = houseAccountPOS;
    }
}
