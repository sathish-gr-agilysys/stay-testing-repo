package com.agilysys.pms.account.model;

import java.util.Map;

public class BatchDepositCollectionRequest {
    private Map<String, DepositPaymentInfo> paymentByAccountId;

    public Map<String, DepositPaymentInfo> getPaymentByAccountId() {
        return paymentByAccountId;
    }

    public void setPaymentByAccountId(Map<String, DepositPaymentInfo> paymentByAccountId) {
        this.paymentByAccountId = paymentByAccountId;
    }
}
