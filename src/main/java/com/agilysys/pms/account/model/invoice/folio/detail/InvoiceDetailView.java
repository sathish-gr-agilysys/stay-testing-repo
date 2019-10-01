/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.invoice.folio.detail;

import java.util.List;

import com.agilysys.pms.account.model.TaxAmountInfo;
import com.agilysys.pms.account.model.invoice.folio.InvoiceFolioView;

public class InvoiceDetailView extends
      InvoiceFolioView<InvoiceFolioLineDetailView, InvoicedSourceAccountDetailView,
            GroupInvoicedSourceAccountDetailView> {

    private List<TaxAmountInfo> taxTotalsBreakdown;

    public List<TaxAmountInfo> getTaxTotalsBreakdown() {
        return taxTotalsBreakdown;
    }

    public void setTaxTotalsBreakdown(List<TaxAmountInfo> taxTotalsBreakdown) {
        this.taxTotalsBreakdown = taxTotalsBreakdown;
    }

    @Override
    public String getType() {
        return "detail";
    }
}
