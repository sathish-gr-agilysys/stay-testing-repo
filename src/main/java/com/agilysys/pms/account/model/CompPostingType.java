package com.agilysys.pms.account.model;

/**
 * Created by MuthalurajG on 9/13/2019.
 */
public enum CompPostingType {
    NO_TAX(false, false),
    INCLUDE_TAX(true, false),
    TAX_FOLLOWS_POSTING(true, true);

    private boolean tax;
    private boolean taxFollowsPosting;

    public boolean isTax() {
        return tax;
    }

    public boolean isTaxFollowsPosting() {
        return taxFollowsPosting;
    }

    CompPostingType(boolean tax, boolean taxFollowsPosting) {
        this.tax = tax;
        this.taxFollowsPosting = taxFollowsPosting;
    }

    public CompPostingType getCompPostingType(boolean tax, boolean taxFollowsPosting) {
        for (CompPostingType value : values()) {
            if (tax == value.isTax() && taxFollowsPosting == value.isTaxFollowsPosting()) {
                return value;
            }
        }
        return null;
    }
}
