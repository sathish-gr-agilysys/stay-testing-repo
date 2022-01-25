/*
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import org.joda.time.LocalDate;

public class PostChargesRequest extends PostChargesRequestBase<Charge> {
    private boolean grouped;
    private boolean isRecurring;
    private boolean postRecurringCharge;
    private String componentBundleId;
    private boolean addOn;
    private boolean routingChargesAlreadyPosted;
    private String ruleId;

    public PostChargesRequest() {
        super();
    }

    public PostChargesRequest(List<Charge> charges, boolean distributed, String name, LocalDate postingDate) {
        super(charges, distributed, name, postingDate);
    }

    public boolean isGrouped() {
        return grouped;
    }

    public void setGrouped(boolean grouped) {
        this.grouped = grouped;
    }

    public boolean isRecurring() {
        return isRecurring;
    }

    public void setIsRecurring(boolean isRecurring) {
        this.isRecurring = isRecurring;
    }

    public boolean isPostRecurringCharge() {
        return postRecurringCharge;
    }

    public void setPostRecurringCharge(boolean postRecurringCharge) {
        this.postRecurringCharge = postRecurringCharge;
    }

    public String getComponentBundleId() {
        return componentBundleId;
    }

    public void setComponentBundleId(String componentBundleId) {
        this.componentBundleId = componentBundleId;
    }

    public boolean isAddOn() {
        return addOn;
    }

    public void setAddOn(boolean addOn) {
        this.addOn = addOn;
    }

    public boolean isRoutingChargesAlreadyPosted() {
        return routingChargesAlreadyPosted;
    }

    public void setRoutingChargesAlreadyPosted(boolean routingChargesAlreadyPosted) {
        this.routingChargesAlreadyPosted = routingChargesAlreadyPosted;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }
}
