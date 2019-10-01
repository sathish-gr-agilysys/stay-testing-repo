/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.invoice.folio.search;

import com.agilysys.pms.account.model.invoice.folio.InvoiceFolioView;

public class InvoiceSearchView extends
      InvoiceFolioView<InvoiceFolioLineSearchView, InvoicedSourceAccountSearchView,
            GroupInvoicedSourceAccountSearchView> {

    @Override
    public String getType() {
        return "search";
    }
}
