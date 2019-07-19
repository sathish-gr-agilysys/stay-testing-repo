/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PaymentByAccountId {

    private Set<String> accountIds;
    private Map<String, Payment> paymentByAccountId;

    public PaymentByAccountId(){
        this.accountIds = new HashSet<>();
    }

    public PaymentByAccountId(Set<String> accountIds, Map<String, Payment> paymentByAccountId) {
        this();
        this.accountIds = accountIds;
        this.paymentByAccountId = paymentByAccountId;
    }

    public Set<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(Set<String> accountIds) {
        this.accountIds = accountIds;
    }

    public Map<String, Payment> getPaymentByAccountId() {
        return paymentByAccountId;
    }

    public void setPaymentByAccountId(Map<String, Payment> paymentByAccountId) {
        this.paymentByAccountId = paymentByAccountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentByAccountId)) return false;

        PaymentByAccountId that = (PaymentByAccountId) o;

        if (accountIds != null ? !accountIds.equals(that.accountIds) : that.accountIds != null) return false;
        return !(paymentByAccountId != null ? !paymentByAccountId.equals(that.paymentByAccountId) :
              that.paymentByAccountId != null);

    }

    @Override
    public int hashCode() {
        int result = accountIds != null ? accountIds.hashCode() : 0;
        result = 31 * result + (paymentByAccountId != null ? paymentByAccountId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PaymentByAccountId{" +
              "accountIds=" + accountIds +
              ", paymentByAccountId=" + paymentByAccountId +
              '}';
    }
}
