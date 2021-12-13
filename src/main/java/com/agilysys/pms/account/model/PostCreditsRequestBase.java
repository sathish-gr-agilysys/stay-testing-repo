package com.agilysys.pms.account.model;

import java.util.List;

public abstract class PostCreditsRequestBase<T extends Credit> {
    private List<T> credits;

    protected PostCreditsRequestBase(){}

    protected PostCreditsRequestBase(List<T> credits){
        this.credits = credits;
    }

    public List<T> getCredits() {
        return credits;
    }

    public void setCredits(List<T> credits) {
        this.credits = credits;
    }
}
