/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public enum CompPostingTaxType {
    NO_TAX(false, false),
    INCLUDE_TAX(true, false),
    TAX_FOLLOWS_POSTING(true, true);

    CompPostingTaxType(boolean tax, boolean taxFollowsPosting) {
        this.tax = tax;
        this.taxFollowsPosting = taxFollowsPosting;
    }

    private boolean tax;
    private boolean taxFollowsPosting;

    public boolean isTax() {
        return tax;
    }

    public boolean isTaxFollowsPosting() {
        return taxFollowsPosting;
    }

    public static CompPostingTaxType fromValues(boolean tax, boolean taxFollowsPosting) {
        for (CompPostingTaxType compPostingTaxType : CompPostingTaxType.values()) {
            if (tax == compPostingTaxType.isTax() && taxFollowsPosting == compPostingTaxType.isTaxFollowsPosting()) {
                return compPostingTaxType;
            }
        }
        return null;
    }
}
