/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.ArrayList;
import java.util.List;

public class GroupInvoicedDetail extends InvoicedSourceAccountDetail {
    private List<InvoicedSourceAccountDetail> invoicedSourceAccountDetails = new ArrayList<>();

    public List<InvoicedSourceAccountDetail> getInvoicedSourceAccountDetails() {
        return invoicedSourceAccountDetails;
    }

    public void setInvoicedSourceAccountDetails(List<InvoicedSourceAccountDetail> invoicedSourceAccountDetails) {
        this.invoicedSourceAccountDetails = invoicedSourceAccountDetails;
    }
}
