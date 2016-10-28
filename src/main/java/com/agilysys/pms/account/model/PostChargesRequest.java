/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

public class PostChargesRequest {

    private List<Charge> charges;
    private boolean distributedCharge;
    private String distributedChargeName;


    public List<Charge> getCharges() {
        return charges;
    }
    public void setCharges(List<Charge> charges) {
        this.charges = charges;
    }
    public boolean isDistributedCharge() {
        return distributedCharge;
    }
    public void setDistributedCharge(boolean distributedCharge) {
        this.distributedCharge = distributedCharge;
    }
    public String getDistributedChargeName() {
        return distributedChargeName;
    }
    public void setDistributedChargeName(String distributedChargeName) {
        this.distributedChargeName = distributedChargeName;
    }
}

