/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.invoice.folio.search;

import com.agilysys.pms.account.model.invoice.folio.InvoiceFolioView;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "id", "accountId", "terms", "payments", "sentOnDate" })
public class InvoiceSearchView extends
      InvoiceFolioView<InvoiceFolioLineSearchView, InvoicedSourceAccountSearchView,
            GroupInvoicedSourceAccountSearchView> {}
