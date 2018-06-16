/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

public class GroupInvoiceDetail extends InvoicedSourceAccountDetail {
    private List<InvoicedSourceAccountDetail> invoicedSourceAccountDetails;

    public List<InvoicedSourceAccountDetail> getInvoicedSourceAccountDetails() {
        return invoicedSourceAccountDetails;
    }

    public void setInvoicedSourceAccountDetails(List<InvoicedSourceAccountDetail> invoicedSourceAccountDetails) {
        this.invoicedSourceAccountDetails = invoicedSourceAccountDetails;
    }

    public BigDecimal getChargesBalance() {
        BigDecimal balance = BigDecimal.ZERO;

        if (invoicedCharges != null) {
            for (LineItemView invoicedChargeItem : invoicedCharges) {
                balance = balance.add(invoicedChargeItem.getLineItemChargesBalance());
            }
        }
        if (invoicedSourceAccountDetails != null) {
            for (InvoicedSourceAccountDetail invoicedSourceAccountDetail : invoicedSourceAccountDetails) {
                balance = balance.add(invoicedSourceAccountDetail.getChargesBalance());
            }
        }
        return balance;
    }

    public BigDecimal getTaxBalance() {
        BigDecimal balance = BigDecimal.ZERO;

        if (invoicedCharges != null) {
            for (LineItemView invoicedChargeItem : invoicedCharges) {
                balance = balance.add(invoicedChargeItem.getLineItemTaxBalance());
            }
        }
        if (invoicedSourceAccountDetails != null) {
            for (InvoicedSourceAccountDetail invoicedSourceAccountDetail : invoicedSourceAccountDetails) {
                balance = balance.add(invoicedSourceAccountDetail.getTaxBalance());
            }
        }
        return balance;
    }

    public BigDecimal getTotalBalance() {
        BigDecimal balance = BigDecimal.ZERO;

        if (invoicedCharges != null) {
            for (LineItemView invoicedChargeItem : invoicedCharges) {
                balance = balance.add(invoicedChargeItem.getLineItemBalance());
            }
        }
        if (invoicedSourceAccountDetails != null) {
            for (InvoicedSourceAccountDetail invoicedSourceAccountDetail : invoicedSourceAccountDetails) {
                balance = balance.add(invoicedSourceAccountDetail.getTotalBalance());
            }
        }
        return balance;
    }
}
