/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.pms.maintenance.domain.JobDetail;

public class BatchDepositJobDetail extends JobDetail {
    private String accountId;
    private Payment payment;
    private String scheduledDepositDueId;
    private String splitId;

    public BatchDepositJobDetail() {
    }

    public BatchDepositJobDetail(String tenantId, String propertyId, String type) {
        super(tenantId, propertyId, type);
    }

    public BatchDepositJobDetail(String tenantId, String propertyId, String type, String accountId, Payment payment,
          String scheduledDepositDueId, String splitId) {
        super(tenantId, propertyId, type);
        this.accountId = accountId;
        this.payment = payment;
        this.splitId = splitId;
        this.scheduledDepositDueId = scheduledDepositDueId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getScheduledDepositDueId() {
        return scheduledDepositDueId;
    }

    public void setScheduledDepositDueId(String scheduledDepositDueId) {
        this.scheduledDepositDueId = scheduledDepositDueId;
    }

    public String getSplitId() {
        return splitId;
    }

    public void setSplitId(String splitId) {
        this.splitId = splitId;
    }
}

