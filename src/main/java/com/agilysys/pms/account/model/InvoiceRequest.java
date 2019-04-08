/**
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import org.joda.time.LocalDate;

import com.agilysys.platform.common.json.schema.MinLengthRestriction;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoiceRequest {
    @JsonProperty(required = true)
    @MinLengthRestriction(1)
    private List<String> folioLineItemIds;

    private Integer terms;

    @JsonProperty(required = true)
    private LocalDate invoiceDate;

    public List<String> getFolioLineItemIds() {
        return folioLineItemIds;
    }

    public void setFolioLineItemIds(List<String> folioLineItemIds) {
        this.folioLineItemIds = folioLineItemIds;
    }

    public Integer getTerms() {
        return terms;
    }

    public void setTerms(Integer terms) {
        this.terms = terms;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
}
