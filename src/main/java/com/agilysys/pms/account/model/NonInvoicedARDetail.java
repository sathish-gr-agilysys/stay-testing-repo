/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

public class NonInvoicedARDetail {
    private String accountId;
    private List<NonInvoicedSourceAccountDetail> nonInvoicedSourceAccountDetails;
    private List<GroupNonInvoicedDetail> groupNonInvoicedDetails;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public List<NonInvoicedSourceAccountDetail> getNonInvoicedSourceAccountDetails() {
        return nonInvoicedSourceAccountDetails;
    }

    public void setNonInvoicedSourceAccountDetails(List<NonInvoicedSourceAccountDetail>
          nonInvoicedSourceAccountDetails) {
        this.nonInvoicedSourceAccountDetails = nonInvoicedSourceAccountDetails;
    }

    public List<GroupNonInvoicedDetail> getGroupNonInvoicedDetails() {
        return groupNonInvoicedDetails;
    }

    public void setGroupNonInvoicedDetails(List<GroupNonInvoicedDetail> groupNonInvoicedDetails) {
        this.groupNonInvoicedDetails = groupNonInvoicedDetails;
    }

    public BigDecimal getNonInvoicedChargesBalance() {
        BigDecimal balance = BigDecimal.ZERO;
        if (nonInvoicedSourceAccountDetails != null) {
            balance = nonInvoicedSourceAccountDetails.stream()
                  .map(nonInvoicedSourceAccountDetail -> nonInvoicedSourceAccountDetail.getNonInvoicedChargesBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        if (groupNonInvoicedDetails != null) {
            return balance.add(groupNonInvoicedDetails.stream()
                  .map(groupNonInvoicedDetail -> groupNonInvoicedDetail.getNonInvoicedChargesBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add));
        }

        return balance;
    }

    public BigDecimal getNonInvoicedChargesTaxBalance() {
        BigDecimal balance = BigDecimal.ZERO;
        if (nonInvoicedSourceAccountDetails != null) {
            return nonInvoicedSourceAccountDetails.stream()
                  .map(nonInvoicedSourceAccountDetail -> nonInvoicedSourceAccountDetail
                        .getNonInvoicedChargesTaxBalance()).reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        if (groupNonInvoicedDetails != null) {
            return balance.add(groupNonInvoicedDetails.stream()
                  .map(groupNonInvoicedDetail -> groupNonInvoicedDetail.getNonInvoicedChargesTaxBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add));
        }

        return balance;
    }

    public BigDecimal getNonInvoicedPaymentsTotalBalance() {
        BigDecimal balance = BigDecimal.ZERO;
        if (nonInvoicedSourceAccountDetails != null) {
            balance = nonInvoicedSourceAccountDetails.stream()
                  .map(nonInvoicedSourceAccountDetail -> nonInvoicedSourceAccountDetail
                        .getNonInvoicedPaymentsTotalBalance()).reduce(BigDecimal.ZERO, BigDecimal::add);
        }
        if (groupNonInvoicedDetails != null) {
            return balance.add(groupNonInvoicedDetails.stream()
                  .map(groupNonInvoicedDetail -> groupNonInvoicedDetail.getNonInvoicedPaymentsTotalBalance())
                  .reduce(BigDecimal.ZERO, BigDecimal::add));
        }

        return balance;
    }

    public BigDecimal getNonInvoicedChargesTotalBalance() {
        return getNonInvoicedChargesBalance().add(getNonInvoicedChargesTaxBalance());
    }

    public BigDecimal getGrandTotalBalance() {
        return getNonInvoicedChargesTotalBalance().add(getNonInvoicedPaymentsTotalBalance());
    }
}
