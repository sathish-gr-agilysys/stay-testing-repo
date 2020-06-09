/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import org.apache.xpath.operations.Bool;

public class CompTransaction {

    private String authorizerId;
    private String departmentId;
    private String compPoints;
    private String playerPoints;
    private String playerOrCardId;
    private String authorizerCode;
    private List<CompRedeemRequest> compRedeemRequests;
    private RedemptionType redemptionType;
    private Boolean isEnhancedRoutingRule;
    private OffSetRule offSetRule;
    private Boolean tax;

    public CompTransaction() {}

    public CompTransaction(String authorizerId, String departmentId, List<CompRedeemRequest> compRedeemRequests,
          Boolean isEnhancedRoutingRule, OffSetRule offSetRule, Boolean tax) {
        this.authorizerId = authorizerId;
        this.departmentId = departmentId;
        this.compRedeemRequests = compRedeemRequests;
        this.isEnhancedRoutingRule = isEnhancedRoutingRule;
        this.offSetRule = offSetRule;
        this.tax = tax;
    }

    public enum RedemptionType {
        PLAYER_POINT("PNT", "PLAYER", "PLAYER BALANCE"),
        COMP_POINT("CMP", "COMP", "COMP BALANCE");

        String bankCode;
        String desc;
        String shortDesc;

        RedemptionType(String bankCode, String shortDesc, String desc) {
            this.bankCode = bankCode;
            this.shortDesc = shortDesc;
            this.desc = desc;
        }

        public String getBankCode() {
            return bankCode;
        }

        public String getDesc() {
            return desc;
        }

        public String getShortDesc() {
            return shortDesc;
        }
    }

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

    public RedemptionType getRedemptionType() {
        return redemptionType;
    }

    public void setRedemptionType(RedemptionType redemptionType) {
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
