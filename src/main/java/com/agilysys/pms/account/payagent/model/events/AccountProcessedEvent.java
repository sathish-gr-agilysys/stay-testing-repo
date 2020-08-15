/*
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.payagent.model.events;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Transient;

import com.agilysys.common.model.PaymentSetting;
import com.agilysys.pms.account.exception.ServiceError;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Event to Complete an existing Pay Agent Transaction
 */
public class AccountProcessedEvent extends PayAgentTransactionEvent {
    private String accountLogs;
    private ServiceError serviceError;
    private Map<String, Object> errorEntityMap = Maps.newHashMap();
    private PaymentSetting paymentSetting;

    public String getAccountLogs() {
        return accountLogs;
    }

    public void setAccountLogs(String accountLogs) {
        this.accountLogs = accountLogs;
    }

    public ServiceError getServiceError() {
        return serviceError;
    }

    public void setServiceError(ServiceError serviceError) {
        this.serviceError = serviceError;
    }

    @Override
    public List<String> getHistoryMessages() {
        return Lists.newArrayList();
    }

    public Map<String, Object> getErrorEntityMap() {
        return errorEntityMap;
    }

    public void setErrorEntityMap(Map<String, Object> errorEntityMap) {
        this.errorEntityMap = errorEntityMap;
    }

    @SuppressWarnings("unchecked")
    public <T> T getErrorEntity(Class<T> clazz) {
        return (T) errorEntityMap.get(clazz.getSimpleName());
    }

    public PaymentSetting getPaymentSetting() {
        return paymentSetting;
    }

    public void setPaymentSetting(PaymentSetting paymentSetting) {
        this.paymentSetting = paymentSetting;
    }

    @Transient
    @Override
    public String getDisplayName() {
        return "Account Processed";
    }
}
