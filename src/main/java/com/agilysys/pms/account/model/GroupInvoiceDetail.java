/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

public class GroupInvoiceDetail extends InvoicedSourceAccountDetail {
    private List<InvoicedSourceAccountDetail> nonGroupInvoicedAccountDetails;

    public List<InvoicedSourceAccountDetail> getNonGroupInvoicedAccountDetails() {
        return nonGroupInvoicedAccountDetails;
    }

    public void setNonGroupInvoicedAccountDetails(List<InvoicedSourceAccountDetail> nonGroupInvoicedAccountDetails) {
        this.nonGroupInvoicedAccountDetails = nonGroupInvoicedAccountDetails;
    }
}
