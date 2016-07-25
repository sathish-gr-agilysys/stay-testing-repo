/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateInvoiceTermsRequest {
    @JsonProperty(required = true)
    private int terms;

    public int getTerms() {
        return terms;
    }

    public void setTerms(int terms) {
        this.terms = terms;
    }
}
