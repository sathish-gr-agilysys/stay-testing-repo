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
    private RedemptionType redemptionType;

    public CompTransaction() {}

    public enum RedemptionType {
        PNT("PATRON", "PATRON POINTS"),
        CMP("COMP", "CASINO COMP");

        String desc;
        String shortDesc;

        RedemptionType(String shortDesc, String desc) {
            this.shortDesc = shortDesc;
            this.desc = desc;
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
}
