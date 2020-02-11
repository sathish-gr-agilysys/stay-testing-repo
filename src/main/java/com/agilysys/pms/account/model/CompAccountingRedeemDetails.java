/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CompAccountingRedeemDetails {
    private String compAuthorizerId;
    private String compDepartmentId;
    private Map<String, Map<String, BigDecimal>> redeemableInfo;

    public CompAccountingRedeemDetails() {
        redeemableInfo = new HashMap<>();
    }

    public CompAccountingRedeemDetails(String compAuthorizerId, String compDepartmentId,
          Map<String, Map<String, BigDecimal>> redeemableInfo) {
        this.compAuthorizerId = compAuthorizerId;
        this.compDepartmentId = compDepartmentId;
        this.redeemableInfo = redeemableInfo;
    }

    public String getCompDepartmentId() {
        return compDepartmentId;
    }

    public void setCompDepartmentId(String compDepartmentId) {
        this.compDepartmentId = compDepartmentId;
    }

    public String getCompAuthorizerId() {
        return compAuthorizerId;
    }

    public void setCompAuthorizerId(String compAuthorizerId) {
        this.compAuthorizerId = compAuthorizerId;
    }

    public Map<String, Map<String, BigDecimal>> getRedeemableInfo() {
        return redeemableInfo;
    }

    public void setRedeemableInfo(Map<String, Map<String, BigDecimal>> redeemableInfo) {
        this.redeemableInfo = redeemableInfo;
    }
}
