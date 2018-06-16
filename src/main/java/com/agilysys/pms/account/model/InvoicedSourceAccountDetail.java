/*
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

public class InvoicedSourceAccountDetail {
    protected String sourceAccountId;
    protected String sourceAccountName;
    protected String sourceAccountType;
    protected String referenceId; // reservationId for GUEST, groupId for GROUP, companyProfileId for COMPANY
    protected List<LineItemView> invoicedCharges;
    protected AccountReferenceInfo accountReferenceInfo;

    public String getSourceAccountId() {
        return sourceAccountId;
    }

    public void setSourceAccountId(String sourceAccountId) {
        this.sourceAccountId = sourceAccountId;
    }

    public String getSourceAccountName() {
        return sourceAccountName;
    }

    public void setSourceAccountName(String sourceAccountName) {
        this.sourceAccountName = sourceAccountName;
    }

    public String getSourceAccountType() {
        return sourceAccountType;
    }

    public void setSourceAccountType(String sourceAccountType) {
        this.sourceAccountType = sourceAccountType;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public List<LineItemView> getInvoicedCharges() {
        return invoicedCharges;
    }

    public void setInvoicedCharges(List<LineItemView> invoicedCharges) {
        this.invoicedCharges = invoicedCharges;
    }

    public AccountReferenceInfo getAccountReferenceInfo() {
        return accountReferenceInfo;
    }

    public void setAccountReferenceInfo(AccountReferenceInfo accountReferenceInfo) {
        this.accountReferenceInfo = accountReferenceInfo;
    }

    public BigDecimal getChargesBalance() {
        BigDecimal balance = BigDecimal.ZERO;

        if (invoicedCharges != null) {
            for (LineItemView invoicedChargeItem : invoicedCharges) {
                balance = balance.add(invoicedChargeItem.getLineItemChargesBalance());
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
        return balance;
    }

    public BigDecimal getTotalBalance() {
        BigDecimal balance = BigDecimal.ZERO;

        if (invoicedCharges != null) {
            for (LineItemView invoicedChargeItem : invoicedCharges) {
                balance = balance.add(invoicedChargeItem.getLineItemBalance());
            }
        }
        return balance;
    }
}
