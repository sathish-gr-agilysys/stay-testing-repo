/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxExemptSettings {
    @JsonProperty(required = true)
    private String taxId;

    public String getTaxId() {
        return this.taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }
}
