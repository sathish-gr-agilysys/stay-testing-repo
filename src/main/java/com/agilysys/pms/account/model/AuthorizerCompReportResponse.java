/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

public class AuthorizerCompReportResponse {
    private String authorizerId;
    private String authorizerName;
    private String authorizerCode;
    private BigDecimal compLimit;
    private String compType;
    private String departmentId;
    private String departmentName;
    private BigDecimal compCharges;

    public AuthorizerCompReportResponse() {
    }

    public AuthorizerCompReportResponse(String authorizerId, String authorizerName, String authorizerCode,
          BigDecimal compLimit, String compType, String departmentId, String departmentName, BigDecimal compCharges) {
        this.authorizerId = authorizerId;
        this.authorizerName = authorizerName;
        this.authorizerCode = authorizerCode;
        this.compLimit = compLimit;
        this.compType = compType;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.compCharges = compCharges;
    }

    public String getAuthorizerName() {
        return authorizerName;
    }

    public void setAuthorizerName(String authorizerName) {
        this.authorizerName = authorizerName;
    }

    public String getAuthorizerCode() {
        return authorizerCode;
    }

    public void setAuthorizerCode(String authorizerCode) {
        this.authorizerCode = authorizerCode;
    }

    public BigDecimal getCompLimit() {
        return compLimit;
    }

    public void setCompLimit(BigDecimal compLimit) {
        this.compLimit = compLimit;
    }

    public String getCompType() {
        return compType;
    }

    public void setCompType(String compType) {
        this.compType = compType;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public BigDecimal getCompCharges() {
        return compCharges;
    }

    public void setCompCharges(BigDecimal compCharges) {
        this.compCharges = compCharges;
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
}
