/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Map;

public class GroupNonInvoicedDetail extends NonInvoicedSourceAccountDetail {
    private Map<String, NonInvoicedSourceAccountDetail> nonInvoicedSourceAccountDetails;

    public Map<String, NonInvoicedSourceAccountDetail> getNonInvoicedSourceAccountDetails() {
        return nonInvoicedSourceAccountDetails;
    }

    public void setNonInvoicedSourceAccountDetails(
          Map<String, NonInvoicedSourceAccountDetail> nonInvoicedSourceAccountDetails) {
        this.nonInvoicedSourceAccountDetails = nonInvoicedSourceAccountDetails;
    }

    public BigDecimal getNonInvoicedChargesBalance() {
        BigDecimal balance = BigDecimal.ZERO;
        if (nonInvoicedCharges != null) {
            balance =
                  nonInvoicedCharges.stream().map(nonInvoicedCharge -> nonInvoicedCharge.getLineItemChargesBalance())
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        if (nonInvoicedSourceAccountDetails != null) {
            balance.add(nonInvoicedSourceAccountDetails.values().stream()
                  .map(nonInvoicedAccount -> nonInvoicedAccount.getNonInvoicedChargesBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add));
        }

        return balance;
    }

    public BigDecimal getNonInvoicedChargesTaxBalance() {
        BigDecimal balance = BigDecimal.ZERO;
        if (nonInvoicedCharges != null) {
            balance = nonInvoicedCharges.stream().map(nonInvoicedCharge -> nonInvoicedCharge.getLineItemTaxBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        if (nonInvoicedSourceAccountDetails != null) {
            balance.add(nonInvoicedSourceAccountDetails.values().stream()
                  .map(nonInvoicedAccount -> nonInvoicedAccount.getNonInvoicedChargesTaxBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add));
        }

        return balance;
    }

    public BigDecimal getNonInvoicedChargesTotalBalance() {
        BigDecimal balance = BigDecimal.ZERO;
        if (nonInvoicedCharges != null) {
            balance = nonInvoicedCharges.stream().map(nonInvoicedCharge -> nonInvoicedCharge.getLineItemBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        if (nonInvoicedSourceAccountDetails != null) {
            balance.add(nonInvoicedSourceAccountDetails.values().stream()
                  .map(nonInvoicedAccount -> nonInvoicedAccount.getNonInvoicedChargesTotalBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add));
        }

        return balance;
    }

    public BigDecimal getNonInvoicedPaymentsTotalBalance() {
        BigDecimal balance = BigDecimal.ZERO;
        if (nonInvoicePayments != null) {
            balance = nonInvoicePayments.stream().map(nonInvoicePayment -> nonInvoicePayment.getLineItemBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        if (nonInvoicedSourceAccountDetails != null) {
            balance.add(nonInvoicedSourceAccountDetails.values().stream()
                  .map(nonInvoicedAccount -> nonInvoicedAccount.getNonInvoicedPaymentsTotalBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add));
        }

        return balance;
    }
}
