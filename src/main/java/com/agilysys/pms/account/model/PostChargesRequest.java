/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

public class PostChargesRequest {

    private List<Charge> charges;
    private boolean distributed;
    private boolean isRecurring;
    private String name;
    private boolean postToFuture;


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

    public boolean isPostToFuture() {
        return postToFuture;
    }

    public void setPostToFuture(boolean postToFuture) {
        this.postToFuture = postToFuture;
    }
}

