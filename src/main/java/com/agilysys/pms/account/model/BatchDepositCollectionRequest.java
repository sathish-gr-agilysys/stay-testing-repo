package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Map;

public class BatchDepositCollectionRequest {
    private Map<String, List<DepositPaymentInfo>> paymentByAccountId;

    public Map<String, List<DepositPaymentInfo>> getPaymentByAccountId() {
        return paymentByAccountId;
    }

    public void setPaymentByAccountId(Map<String, List<DepositPaymentInfo>> paymentByAccountId) {
        this.paymentByAccountId = paymentByAccountId;
    }
}
