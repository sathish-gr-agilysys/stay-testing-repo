/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.model.invoice.folio;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.joda.time.LocalDate;

import com.agilysys.pms.account.model.TransactionType;

public abstract class InvoicedSourceAccountFolioView<T extends InvoiceFolioLineView<T>> {
    private LocalDate arrivalDate;
    private String confirmationCode;
    private LocalDate departureDate;
    private String groupCode;
    private List<T> invoicedCharges;
    private String name;
    private String sourceAccountId;
    private String referenceNumber;

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

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public BigDecimal getChargesBalance() {
        if (CollectionUtils.isEmpty(invoicedCharges)) {
            return null;
        }

        BigDecimal chargesBalance = BigDecimal.ZERO;
        for (T invoicedChargeItem : invoicedCharges) {
            String folioTransactionType = invoicedChargeItem.getFolioTransactionType();
            if (folioTransactionType == null ||
                  (!folioTransactionType.equalsIgnoreCase(TransactionType.PAYMENT.toString()) &&
                        !folioTransactionType.equalsIgnoreCase(TransactionType.REFUND.toString()))) {
                chargesBalance = chargesBalance.add(invoicedChargeItem.getLineItemChargesBalance());
            }
        }

        return chargesBalance;
    }

    public BigDecimal getTaxBalance() {
        if (CollectionUtils.isEmpty(invoicedCharges)) {
            return null;
        }

        BigDecimal taxBalance = BigDecimal.ZERO;
        for (T invoicedChargeItem : invoicedCharges) {
            String folioTransactionType = invoicedChargeItem.getFolioTransactionType();
            if (folioTransactionType == null ||
                  (!folioTransactionType.equalsIgnoreCase(TransactionType.PAYMENT.toString()) &&
                        !folioTransactionType.equalsIgnoreCase(TransactionType.REFUND.toString()))) {
                taxBalance = taxBalance.add(invoicedChargeItem.getLineItemTaxBalance());
            }
        }

        return taxBalance;
    }

    public BigDecimal getTotalBalance() {
        if (CollectionUtils.isEmpty(invoicedCharges)) {
            return null;
        }

        BigDecimal lineItemBalance = BigDecimal.ZERO;
        for (T invoicedChargeItem : invoicedCharges) {
            String folioTransactionType = invoicedChargeItem.getFolioTransactionType();
            if (folioTransactionType == null ||
                  (!folioTransactionType.equalsIgnoreCase(TransactionType.PAYMENT.toString()) &&
                        !folioTransactionType.equalsIgnoreCase(TransactionType.REFUND.toString()))) {
                lineItemBalance = lineItemBalance.add(invoicedChargeItem.getLineItemBalance());
            }
        }

        return lineItemBalance;
    }

    public BigDecimal getPayment() {
        if (CollectionUtils.isEmpty(invoicedCharges)) {
            return null;
        }

        BigDecimal payment = BigDecimal.ZERO;
        for (T invoicedChargeItem : invoicedCharges) {
            if (invoicedChargeItem.getPayment() != null) {
                payment = payment.add(invoicedChargeItem.getPayment());
            }
        }
        return payment;
    }
}
