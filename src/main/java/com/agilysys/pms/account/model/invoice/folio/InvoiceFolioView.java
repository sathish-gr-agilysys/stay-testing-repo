/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.invoice.folio;

import java.util.List;

import com.agilysys.pms.account.model.invoice.base.InvoiceBaseView;

public abstract class InvoiceFolioView<FOLIO_LINE_VIEW extends InvoiceFolioLineView<FOLIO_LINE_VIEW>, SOURCE_VIEW extends
      InvoicedSourceAccountFolioView<FOLIO_LINE_VIEW>, GROUP_SOURCE_VIEW extends
      GroupInvoicedSourceAccountFolioView<FOLIO_LINE_VIEW, SOURCE_VIEW>>
      extends InvoiceBaseView {

    private List<GROUP_SOURCE_VIEW> groupInvoiceDetails;
    private List<SOURCE_VIEW> nonGroupInvoiceDetails;

    public List<GROUP_SOURCE_VIEW> getGroupInvoiceDetails() {
        return groupInvoiceDetails;
    }

    public void setGroupInvoiceDetails(List<GROUP_SOURCE_VIEW> groupInvoiceDetails) {
        this.groupInvoiceDetails = groupInvoiceDetails;
    }

    public List<SOURCE_VIEW> getNonGroupInvoiceDetails() {
        return nonGroupInvoiceDetails;
    }

    public void setNonGroupInvoiceDetails(List<SOURCE_VIEW> nonGroupInvoiceDetails) {
        this.nonGroupInvoiceDetails = nonGroupInvoiceDetails;
    }
}
