/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.ArrayList;
import java.util.List;

public class ARInvoiceDetail {
    List<NonInvoicedSourceAccountDetail> groupedCharges;
    List<NonInvoicedSourceAccountDetail> nonGroupedCharges;

    public ARInvoiceDetail(){
        groupedCharges = new ArrayList<>();
        nonGroupedCharges = new ArrayList<>();
    }

    public List<NonInvoicedSourceAccountDetail> getGroupedCharges() {
        return groupedCharges;
    }

    public void setGroupedCharges(List<NonInvoicedSourceAccountDetail> groupedCharges) {
        this.groupedCharges = groupedCharges;
    }

    public List<NonInvoicedSourceAccountDetail> getNonGroupedCharges() {
        return nonGroupedCharges;
    }

    public void setNonGroupedCharges(List<NonInvoicedSourceAccountDetail> nonGroupedCharges) {
        this.nonGroupedCharges = nonGroupedCharges;
    }
}
