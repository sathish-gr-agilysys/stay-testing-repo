/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.model.invoice.folio;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.joda.time.LocalDate;

public class GroupInvoicedSourceAccountFolioView<FOLIO_LINE_VIEW extends InvoiceFolioLineView<FOLIO_LINE_VIEW>,
      SOURCE_VIEW extends InvoicedSourceAccountFolioView<FOLIO_LINE_VIEW>> {
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private String groupCode;
    private List<FOLIO_LINE_VIEW> invoicedCharges;
    private List<SOURCE_VIEW> invoicedSourceAccountViews;
    private String name;

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public List<FOLIO_LINE_VIEW> getInvoicedCharges() {
        return invoicedCharges;
    }

    public void setInvoicedCharges(List<FOLIO_LINE_VIEW> invoicedCharges) {
        this.invoicedCharges = invoicedCharges;
    }

    public List<SOURCE_VIEW> getInvoicedSourceAccountViews() {
        return invoicedSourceAccountViews;
    }

    public void setInvoicedSourceAccountViews(List<SOURCE_VIEW> invoicedSourceAccountBaseViews) {
        this.invoicedSourceAccountViews = invoicedSourceAccountBaseViews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getChargesBalance() {
        BigDecimal chargesBalance = getGroupChargesBalance();
        if (CollectionUtils.isEmpty(invoicedSourceAccountViews)) {
            return null;
        }

        chargesBalance = chargesBalance != null ? chargesBalance : BigDecimal.ZERO;
        for (SOURCE_VIEW sourceView : invoicedSourceAccountViews) {
            chargesBalance = chargesBalance.add(sourceView.getChargesBalance());
        }

        return chargesBalance;
    }

    public BigDecimal getTaxBalance() {
        BigDecimal groupSourceTaxBalance = getGroupTaxBalance();
        if (CollectionUtils.isEmpty(invoicedSourceAccountViews)) {
            return groupSourceTaxBalance;
        }

        BigDecimal taxBalance = groupSourceTaxBalance == null ? BigDecimal.ZERO : groupSourceTaxBalance;
        for (SOURCE_VIEW sourceView : invoicedSourceAccountViews) {
            taxBalance = taxBalance.add(sourceView.getTaxBalance());
        }

        return taxBalance;
    }

    public BigDecimal getTotalBalance() {
        BigDecimal groupSourceTotalBalance = getGroupTotalBalance();
        if (CollectionUtils.isEmpty(invoicedSourceAccountViews)) {
            return groupSourceTotalBalance;
        }

        BigDecimal totalBalance = groupSourceTotalBalance == null ? BigDecimal.ZERO : groupSourceTotalBalance;
        for (SOURCE_VIEW sourceView : invoicedSourceAccountViews) {
            totalBalance = totalBalance.add(sourceView.getTotalBalance());
        }

        return totalBalance;
    }

    private BigDecimal getGroupTaxBalance() {
        if (CollectionUtils.isEmpty(invoicedCharges)) {
            return null;
        }

        BigDecimal taxBalance = BigDecimal.ZERO;
        for (FOLIO_LINE_VIEW invoicedChargeItem : invoicedCharges) {
            taxBalance = taxBalance.add(invoicedChargeItem.getLineItemTaxBalance());
        }

        return taxBalance;
    }

    private BigDecimal getGroupTotalBalance() {
        if (CollectionUtils.isEmpty(invoicedCharges)) {
            return null;
        }

        BigDecimal lineItemBalance = BigDecimal.ZERO;
        for (FOLIO_LINE_VIEW invoicedChargeItem : invoicedCharges) {
            lineItemBalance = lineItemBalance.add(invoicedChargeItem.getLineItemBalance());
        }

        return lineItemBalance;
    }

    private BigDecimal getGroupChargesBalance() {
        if (CollectionUtils.isEmpty(invoicedCharges)) {
            return null;
        }

        BigDecimal chargesBalance = BigDecimal.ZERO;
        for (FOLIO_LINE_VIEW invoicedChargeItem : invoicedCharges) {
            chargesBalance = chargesBalance.add(invoicedChargeItem.getLineItemChargesBalance());
        }

        return chargesBalance;
    }
}
