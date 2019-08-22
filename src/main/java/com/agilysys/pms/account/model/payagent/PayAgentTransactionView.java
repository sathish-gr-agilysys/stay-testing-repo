/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.payagent;

import com.agilysys.common.model.PaymentSetting;
import com.agilysys.pms.rguestpayshim.exception.PayErrorData;
import com.agilysys.pms.rguestpayshim.model.PayAgentBaseRequest;
import com.agilysys.pms.rguestpayshim.model.PayAgentBaseResponse;
import com.agilysys.pms.rguestpayshim.model.transaction.AuthRequest;
import com.agilysys.pms.rguestpayshim.model.transaction.AuthResponse;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

public class PayAgentTransactionView {
    private String requestId;
    private String accountId;
    private PayAgentBaseRequest request;
    private PayAgentBaseResponse response;
    private PayTransactionStatus payAgentStatus;
    private String payAgentUrl;
    private String callbackUrl;
    private String payAgentResponseType;
    private String payAgentErrorResponseType;
    private String accountLogs;
    private String accountErrorCode;
    private String accountErrorDescription;
    private PaymentSetting paymentSetting;
    private String pantryName;

    public PayAgentTransactionView() {
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public PayAgentBaseRequest getRequest() {
        return request;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "typeRequest")
    @JsonSubTypes(value = {
          @JsonSubTypes.Type(name = "AuthRequest", value = AuthRequest.class), })
    public void setRequest(PayAgentBaseRequest request) {
        this.request = request;
    }

    /**
     * @return the payAgentStatus
     */
    public PayTransactionStatus getPayAgentStatus() {
        return payAgentStatus;
    }

    /**
     * @param payAgentStatus the payAgentStatus to set
     */
    public void setPayAgentStatus(PayTransactionStatus payAgentStatus) {
        this.payAgentStatus = payAgentStatus;
    }

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
     * @return the accountErrorCode
     */
    public String getAccountErrorCode() {
        return accountErrorCode;
    }

    /**
     * @param accountErrorCode the accountErrorCode to set
     */
    public void setAccountErrorCode(String accountErrorCode) {
        this.accountErrorCode = accountErrorCode;
    }

    /**
     * @return the accountErrorDescription
     */
    public String getAccountErrorDescription() {
        return accountErrorDescription;
    }

    /**
     * @param accountErrorDescription the accountErrorDescription to set
     */
    public void setAccountErrorDescription(String accountErrorDescription) {
        this.accountErrorDescription = accountErrorDescription;
    }

    public String getPayAgentUrl() {
        return payAgentUrl;
    }

    public void setPayAgentUrl(String payAgentUrl) {
        this.payAgentUrl = payAgentUrl;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    /**
     * @return the response
     */
    public PayAgentBaseResponse getResponse() {
        return response;
    }

    /**
     * @param response the response from payAgent to set
     */
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "typeResponse")
    @JsonSubTypes(value = {
          @JsonSubTypes.Type(name = "AuthResponse", value = AuthResponse.class),
          @JsonSubTypes.Type(name = "PayErrorData", value = PayErrorData.class), })
    public void setResponse(PayAgentBaseResponse response) {
        this.response = response;
    }

    /**
     * @return the payAgentBaseResponseType
     */
    public String getPayAgentResponseType() {
        return payAgentResponseType;
    }

    /**
     * @param payAgentResponseType the payAgentBaseResponseType to set
     */
    public void setPayAgentResponseType(String payAgentResponseType) {
        this.payAgentResponseType = payAgentResponseType;
    }

    /**
     * @return the payAgentErrorResponseType
     */
    public String getPayAgentErrorResponseType() {
        return payAgentErrorResponseType;
    }

    /**
     * @param payAgentErrorResponseType the payAgentErrorResponseType to set
     */
    public void setPayAgentErrorResponseType(String payAgentErrorResponseType) {
        this.payAgentErrorResponseType = payAgentErrorResponseType;
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

    public String getPantryName() {
        return pantryName;
    }

    public void setPantryName(String pantryName) {
        this.pantryName = pantryName;
    }
}
