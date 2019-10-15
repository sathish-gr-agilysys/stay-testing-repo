/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.invoice.folio;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

public abstract class GroupInvoicedSourceAccountFolioView<FOLIO_LINE_VIEW extends InvoiceFolioLineView<FOLIO_LINE_VIEW>,
      SOURCE_VIEW extends InvoicedSourceAccountFolioView<FOLIO_LINE_VIEW>>
      extends InvoicedSourceAccountFolioView<FOLIO_LINE_VIEW> {

    private List<SOURCE_VIEW> invoicedSourceAccountViews;

    public List<SOURCE_VIEW> getInvoicedSourceAccountViews() {
        return invoicedSourceAccountViews;
    }

    public void setInvoicedSourceAccountViews(List<SOURCE_VIEW> invoicedSourceAccountBaseViews) {
        this.invoicedSourceAccountViews = invoicedSourceAccountBaseViews;
    }

    @Override
    public BigDecimal getChargesBalance() {
        BigDecimal chargesBalance = super.getChargesBalance();
        if (CollectionUtils.isEmpty(invoicedSourceAccountViews)) {
            return chargesBalance;
        }

        chargesBalance = chargesBalance != null ? chargesBalance : BigDecimal.ZERO;
        for (SOURCE_VIEW sourceView : invoicedSourceAccountViews) {
            chargesBalance = chargesBalance.add(sourceView.getChargesBalance());
        }

        return chargesBalance;
    }

    @Override
    public BigDecimal getTaxBalance() {
        BigDecimal groupSourceTaxBalance = super.getTaxBalance();
        if (CollectionUtils.isEmpty(invoicedSourceAccountViews)) {
            return groupSourceTaxBalance;
        }

        BigDecimal taxBalance = groupSourceTaxBalance == null ? BigDecimal.ZERO : groupSourceTaxBalance;
        for (SOURCE_VIEW sourceView : invoicedSourceAccountViews) {
            taxBalance = taxBalance.add(sourceView.getTaxBalance());
        }

        return taxBalance;
    }

    @Override
    public BigDecimal getTotalBalance() {
        BigDecimal groupSourceTotalBalance = super.getTotalBalance();
        if (CollectionUtils.isEmpty(invoicedSourceAccountViews)) {
            return groupSourceTotalBalance;
        }

        BigDecimal totalBalance = groupSourceTotalBalance == null ? BigDecimal.ZERO : groupSourceTotalBalance;
        for (SOURCE_VIEW sourceView : invoicedSourceAccountViews) {
            totalBalance = totalBalance.add(sourceView.getTotalBalance());
        }

        return totalBalance;
    }
}
