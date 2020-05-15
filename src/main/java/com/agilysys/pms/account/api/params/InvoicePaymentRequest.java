package com.agilysys.pms.account.api.params;

import java.util.Set;

import com.google.common.collect.Sets;

public class InvoicePaymentRequest {
    private Set<String> accountIds = Sets.newHashSet();

    public InvoicePaymentRequest() {
    }

    public InvoicePaymentRequest(Set<String> accountIds) {
        this.accountIds = accountIds;
    }

    public Set<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(Set<String> accountIds) {
        this.accountIds = accountIds;
    }
}
