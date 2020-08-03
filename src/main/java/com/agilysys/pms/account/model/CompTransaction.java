/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

public class CompTransaction {

    private String authorizerId;
    private String departmentId;
    private String compPoints;
    private String playerPoints;
    private String playerOrCardId;
    private String authorizerCode;
    private List<CompRedeemRequest> compRedeemRequests;
    private String redemptionId;
    private String redemptionType;

    public CompTransaction() {}

    public String getAuthorizerId() {
        return authorizerId;
    }

    public void setAuthorizerId(String authorizerId) {
        this.authorizerId = authorizerId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getCompPoints() {
        return compPoints;
    }

    public void setCompPoints(String compPoints) {
        this.compPoints = compPoints;
    }

    public String getPlayerPoints() {
        return playerPoints;
    }

    public void setPlayerPoints(String playerPoints) {
        this.playerPoints = playerPoints;
    }

    public String getPlayerOrCardId() {
        return playerOrCardId;
    }

    public void setPlayerOrCardId(String playerOrCardId) {
        this.playerOrCardId = playerOrCardId;
    }

    public String getAuthorizerCode() {
        return authorizerCode;
    }

    public void setAuthorizerCode(String authorizerCode) {
        this.authorizerCode = authorizerCode;
    }

    public List<CompRedeemRequest> getCompRedeemRequests() {
        return compRedeemRequests;
    }

    public void setCompRedeemRequests(List<CompRedeemRequest> compRedeemRequests) {
        this.compRedeemRequests = compRedeemRequests;
    }

    public String getRedemptionId() { return redemptionId; }

    public void setRedemptionId(String redemptionId) { this.redemptionId = redemptionId; }

    public String getRedemptionType() {
        return redemptionType;
    }

    public void setRedemptionType(String redemptionType) {
        this.redemptionType = redemptionType;
    }

    public Boolean getEnhancedRoutingRule() {
        return isEnhancedRoutingRule;
    }

    public boolean isEnhancedRoutingRule() {
        return Boolean.TRUE.equals(isEnhancedRoutingRule);
    }

    public void setEnhancedRoutingRule(Boolean enhancedRoutingRule) {
        isEnhancedRoutingRule = enhancedRoutingRule;
    }

    public OffSetRule getOffSetRule() {
        return offSetRule;
    }

    public void setOffSetRule(OffSetRule offSetRule) {
        this.offSetRule = offSetRule;
    }

    public Boolean getTax() {
        return tax;
    }

    public void setTax(Boolean tax) {
        this.tax = tax;
    }
}
