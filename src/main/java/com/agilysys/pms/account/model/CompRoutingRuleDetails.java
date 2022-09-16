/*
 * (C) 2022 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import org.joda.time.LocalDate;

public class CompRoutingRuleDetails {
    private String routingRuleTemplateId;
    private String authorizerId;
    private List<LocalDate> dates;

    public String getRoutingRuleTemplateId() {
        return routingRuleTemplateId;
    }

    public void setRoutingRuleTemplateId(String routingRuleTemplateId) {
        this.routingRuleTemplateId = routingRuleTemplateId;
    }

    public String getAuthorizerId() {
        return authorizerId;
    }

    public void setAuthorizerId(String authorizerId) {
        this.authorizerId = authorizerId;
    }

    public List<LocalDate> getDates() {
        return dates;
    }

    public void setDates(List<LocalDate> dates) {
        this.dates = dates;
    }
}
