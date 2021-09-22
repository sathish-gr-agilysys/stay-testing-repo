/*
 * (C) 2021 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import org.joda.time.LocalDate;

public abstract class PostChargesRequestBase<T extends Charge> {
    private List<T> charges;
    private boolean distributed;
    private String name;
    private LocalDate postingDate;

    protected PostChargesRequestBase() {}

    protected PostChargesRequestBase(List<T> charges, boolean distributed, String name, LocalDate postingDate) {
        this.charges = charges;
        this.distributed = distributed;
        this.name = name;
        this.postingDate = postingDate;
    }

    public List<T> getCharges() {
        return charges;
    }

    public void setCharges(List<T> charges) {
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

    public LocalDate getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(LocalDate postingDate) {
        this.postingDate = postingDate;
    }
}
