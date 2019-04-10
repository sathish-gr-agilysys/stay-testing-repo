/**
 * (C) 2016 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * Invoice views returned by the endpoint
 *
 * Created by sulgaonkara on 10/4/16.
 */
public class InvoiceReportResult {

    private List<InvoiceView> invoiceViews = Lists.newArrayList();

    public List<InvoiceView> getInvoiceViews() {
        return Lists.newArrayList(invoiceViews);
    }

    public void setInvoiceViews(List<InvoiceView> invoiceViews) {
        this.invoiceViews.addAll(invoiceViews);
    }

    public void appendInvoiceViews(InvoiceView invoiceView) {
        this.invoiceViews.add(invoiceView);
    }
}
