/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

public class NonInvoicedARDetail {
    private String accountId;
    private List<NonInvoicedSourceAccountDetail> nonInvoicedSourceAccountDetails;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public List<NonInvoicedSourceAccountDetail> getNonInvoicedSourceAccountDetails() {
        return nonInvoicedSourceAccountDetails;
    }

    public void setNonInvoicedSourceAccountDetails(
          List<NonInvoicedSourceAccountDetail> nonInvoicedSourceAccountDetails) {
        this.nonInvoicedSourceAccountDetails = nonInvoicedSourceAccountDetails;
    }

    public BigDecimal getNonInvoicedChargesBalance() {
        if (nonInvoicedSourceAccountDetails != null) {
            return nonInvoicedSourceAccountDetails.stream()
                  .map(nonInvoicedSourceAccountDetail -> nonInvoicedSourceAccountDetail.getNonInvoicedChargesBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        return BigDecimal.ZERO;
    }

    public BigDecimal getNonInvoicedChargesTaxBalance() {
        if (nonInvoicedSourceAccountDetails != null) {
            return nonInvoicedSourceAccountDetails.stream()
                  .map(nonInvoicedSourceAccountDetail -> nonInvoicedSourceAccountDetail
                        .getNonInvoicedChargesTaxBalance()).reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        return BigDecimal.ZERO;
    }

    public BigDecimal getNonInvoicedPaymentsTotalBalance() {
        if (nonInvoicedSourceAccountDetails != null) {
            return nonInvoicedSourceAccountDetails.stream()
                  .map(nonInvoicedSourceAccountDetail -> nonInvoicedSourceAccountDetail
                        .getNonInvoicedPaymentsTotalBalance()).reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        return BigDecimal.ZERO;
    }

    public BigDecimal getNonInvoicedChargesTotalBalance() {
        return getNonInvoicedChargesBalance().add(getNonInvoicedChargesTaxBalance());
    }

    public BigDecimal getGrandTotalBalance() {
        return getNonInvoicedChargesTotalBalance().add(getNonInvoicedPaymentsTotalBalance());
    }
}
