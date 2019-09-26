/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.model.invoice.folio;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.joda.time.LocalDate;

public class InvoicedSourceAccountFolioView<T extends InvoiceFolioLineView<T>> {
    private LocalDate arrivalDate;
    private String confirmationCode;
    private LocalDate departureDate;
    private String groupCode;
    private List<T> invoicedCharges;
    private String name;
    private String sourceAccountId;

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
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

    public List<T> getInvoicedCharges() {
        return invoicedCharges;
    }

    public void setInvoicedCharges(List<T> invoicedCharges) {
        this.invoicedCharges = invoicedCharges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(String sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public BigDecimal getChargesBalance() {
        if (CollectionUtils.isEmpty(invoicedCharges)) {
            return null;
        }

        BigDecimal chargesBalance = BigDecimal.ZERO;
        for (T invoicedChargeItem : invoicedCharges) {
            chargesBalance = chargesBalance.add(invoicedChargeItem.getLineItemChargesBalance());
        }

        return chargesBalance;
    }

    public BigDecimal getTaxBalance() {
        if (CollectionUtils.isEmpty(invoicedCharges)) {
            return null;
        }

        BigDecimal taxBalance = BigDecimal.ZERO;
        for (T invoicedChargeItem : invoicedCharges) {
            taxBalance = taxBalance.add(invoicedChargeItem.getLineItemTaxBalance());
        }

        return taxBalance;
    }

    public BigDecimal getTotalBalance() {
        if (CollectionUtils.isEmpty(invoicedCharges)) {
            return null;
        }

        BigDecimal lineItemBalance = BigDecimal.ZERO;
        for (T invoicedChargeItem : invoicedCharges) {
            lineItemBalance = lineItemBalance.add(invoicedChargeItem.getLineItemBalance());
        }

        return lineItemBalance;
    }
}
