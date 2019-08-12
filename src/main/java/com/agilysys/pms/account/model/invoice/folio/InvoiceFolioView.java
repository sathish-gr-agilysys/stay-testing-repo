/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.model.invoice.folio;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.agilysys.pms.account.model.invoice.base.InvoiceBaseView;

public class InvoiceFolioView<FOLIO_LINE_VIEW extends InvoiceFolioLineView<FOLIO_LINE_VIEW>, SOURCE_VIEW extends
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

    public BigDecimal getTotalAmount() {
        BigDecimal balance = BigDecimal.ZERO;
        if (CollectionUtils.isNotEmpty(nonGroupInvoiceDetails)) {
            balance = nonGroupInvoiceDetails.stream().map(SOURCE_VIEW::getTotalBalance)
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        if (CollectionUtils.isNotEmpty(groupInvoiceDetails)) {
            balance = balance.add(groupInvoiceDetails.stream().map(GROUP_SOURCE_VIEW::getTotalBalance)
                  .reduce(BigDecimal.ZERO, BigDecimal::add));
        }

        return balance;
    }
}
