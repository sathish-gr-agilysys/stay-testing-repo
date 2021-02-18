/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

public class PostPosCreditRequest {
    private List<PosCredit> posCredits;
    private BigDecimal totalAmount;
    private String name;

    public List<PosCredit> getPosCredits() {
        return posCredits;
    }

    public void setPosCredits(List<PosCredit> posCredits) {
        this.posCredits = posCredits;
    }

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
}
