/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.payagent.model.events;

import java.util.List;
import java.util.Map;

import org.elasticsearch.common.collect.Lists;
import org.springframework.data.annotation.Transient;

import com.agilysys.common.model.PaymentSetting;
import com.agilysys.pms.account.exception.ServiceError;
import com.google.common.collect.Maps;

/**
 * Event to Complete an existing Pay Agent Transaction
 */
public class AccountProcessedEvent extends PayAgentTransactionEvent {
    private String accountLogs;
    private ServiceError serviceError;
    private Map<String, Object> errorEntityMap = Maps.newHashMap();
    private PaymentSetting paymentSetting;

    /**
     * @return the accountLogs
     */
    public String getAccountLogs() {
        return accountLogs;
    }

    /**
     * @param accountLogs the accountLogs to set
     */
    public void setAccountLogs(String accountLogs) {
        this.accountLogs = accountLogs;
    }

    /**
     * @return the serviceError
     */
    public ServiceError getServiceError() {
        return serviceError;
    }

    /**
     * @param serviceError the serviceError to set
     */
    public void setServiceError(ServiceError serviceError) {
        this.serviceError = serviceError;
    }

    /* (non-Javadoc)
     * @see com.agilysys.pms.account.payagent.model.events.PayAgentTransactionEvent#getHistoryMessages()
     */
    @Override
    public List<String> getHistoryMessages() {
        return Lists.newArrayList();
    }

    /**
     * @return the errorEntityMap
     */
    public Map<String, Object> getErrorEntityMap() {
        return errorEntityMap;
    }

    /**
     * @param errorEntityMap the errorEntityMap to set
     */
    public void setErrorEntityMap(Map<String, Object> errorEntityMap) {
        this.errorEntityMap = errorEntityMap;
    }

    @SuppressWarnings("unchecked")
    public <T> T getErrorEntity(Class<T> clazz) {
        return (T) errorEntityMap.get(clazz.getSimpleName());
    }

    /**
     * @return the paymentSetting
     */
    public PaymentSetting getPaymentSetting() {
        return paymentSetting;
    }

    /**
     * @param paymentSetting the paymentSetting to set
     */
    public void setPaymentSetting(PaymentSetting paymentSetting) {
        this.paymentSetting = paymentSetting;
    }

    @Transient
    @Override
    public String getDisplayName() {
        return "Account Processed";
    }

    /* (non-Javadoc)
     * @see com.agilysys.platform.persistence.eventsourcing.DomainEvent#getEventVersion()
     */
    @Override
    public long getEventVersion() {
        return 0;
    }

}
