/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import org.joda.time.LocalDate;

public class AuthorizerCompReportRequest {
    private LocalDate startDate;
    private LocalDate endDate;
    private List<String> adminCompAuthorizerIds;
    private List<String> playerCompAuthorizerIds;
    private List<String> departmentIds;

    public AuthorizerCompReportRequest() {
    }

    public AuthorizerCompReportRequest(LocalDate startDate, LocalDate endDate, List<String> adminCompAuthorizerIds,
          List<String> playerCompAuthorizerIds, List<String> departmentIds) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.adminCompAuthorizerIds = adminCompAuthorizerIds;
        this.playerCompAuthorizerIds = playerCompAuthorizerIds;
        this.departmentIds = departmentIds;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<String> getAdminCompAuthorizerIds() {
        return adminCompAuthorizerIds;
    }

    public void setAdminCompAuthorizerIds(List<String> adminCompAuthorizerIds) {
        this.adminCompAuthorizerIds = adminCompAuthorizerIds;
    }

    public List<String> getPlayerCompAuthorizerIds() {
        return playerCompAuthorizerIds;
    }

    public void setPlayerCompAuthorizerIds(List<String> playerCompAuthorizerIds) {
        this.playerCompAuthorizerIds = playerCompAuthorizerIds;
    }

    public List<String> getDepartmentIds() {
        return departmentIds;
    }

    public void setDepartmentIds(List<String> departmentIds) {
        this.departmentIds = departmentIds;
    }
}
