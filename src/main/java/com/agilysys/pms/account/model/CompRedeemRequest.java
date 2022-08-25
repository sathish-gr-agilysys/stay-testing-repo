/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

public class CompRedeemRequest {
    private String lineItemId;
    private String itemId;
    private List<String> taxClasses;
    private List<String> taxExemptClasses;
    private BigDecimal amount;
    private String compOfferId;
    private String compOfferName;
    private boolean compRule;

    public CompRedeemRequest() {
    }

    public CompRedeemRequest(String lineItemId, String itemId, List<String> taxClasses, List<String> taxExemptClasses,
          BigDecimal amount) {
        this.lineItemId = lineItemId;
        this.itemId = itemId;
        this.taxClasses = taxClasses;
        this.taxExemptClasses = taxExemptClasses;
        this.amount = amount;
    }

    public String getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<String> getTaxClasses() {
        return taxClasses;
    }

    public void setTaxClasses(List<String> taxClasses) {
        this.taxClasses = taxClasses;
    }

    public List<String> getTaxExemptClasses() {
        return taxExemptClasses;
    }

    public void setTaxExemptClasses(List<String> taxExemptClasses) {
        this.taxExemptClasses = taxExemptClasses;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getCompOfferId() {
        return compOfferId;
    }

    public void setCompOfferId(String compOfferId) {
        this.compOfferId = compOfferId;
    }

    public String getCompOfferName() {
        return compOfferName;
    }

    public void setCompOfferName(String compOfferName) {
        this.compOfferName = compOfferName;
    }

    public boolean isCompRule() {
        return compRule;
    }

    public void setCompRule(boolean compRule) {
        this.compRule = compRule;
    }
}
