/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import org.joda.time.LocalDate;

public class PostChargesRequest {

    private List<Charge> charges;
    private boolean distributed;
    private boolean grouped;
    private boolean isRecurring;
    private String name;
    private LocalDate postingDate;
    private boolean postRecurringCharge;
    private String componentBundleId;
    private boolean addOn;

    public PostChargesRequest() {
    }

    public PostChargesRequest(boolean distributed, String name, List<Charge> charges, LocalDate postingDate) {
        this.distributed = distributed;
        this.name = name;
        this.charges = charges;
        this.postingDate = postingDate;
    }

    public List<Charge> getCharges() {
        return charges;
    }
    public void setCharges(List<Charge> charges) {
        this.charges = charges;
    }

    public boolean isDistributed() {
        return distributed;
    }

    public void setDistributed(boolean distributed) {
        this.distributed = distributed;
    }

    public boolean isGrouped() {
        return grouped;
    }

    public void setGrouped(boolean grouped) {
        this.grouped = grouped;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRecurring() {
        return isRecurring;
    }

    public void setIsRecurring(boolean isRecurring) {
        this.isRecurring = isRecurring;
    }

    public LocalDate getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(LocalDate postingDate) {
        this.postingDate = postingDate;
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
}

