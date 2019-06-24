/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.payagent;

import static com.agilysys.pms.common.exceptions.ExceptionFactory.accountException;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import com.agilysys.pms.account.exception.ServiceError;
import com.agilysys.pms.account.model.PaymentTransaction;
import com.agilysys.pms.common.exceptions.account.AccountErrorCode;

/**
 * This is the generic request coming up from browser to request the payload
 */
public class PayTransactionRequest {
    private String profileId;
    private String accountId;
    private String reservationId;
    private String invoiceNumber;
    private String terminalId;
    private PayActionType payActionType;
    private String payAgentCode;
    private String payAgentUrl;
    private String deviceGuid;
    private String deviceHandlerId;
    // Flags for adding a payment method
    private boolean connectedToDefaultFolio;
    private boolean attachToAccount;
    private boolean makeDefaultOnAccount;
    private boolean attachToProfile;
    private boolean makeDefaultOnProfile;
    private boolean thirdPartyPay;
    private boolean doNotDisclose;
    // Fields for making payment 
    private List<PaymentTransaction> payTransactions = new ArrayList<>();
    private String pantryName;

    public PayTransactionRequest() {
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public PayActionType getPayActionType() {
        return payActionType;
    }

    public void setPayActionType(PayActionType payActionType) {
        this.payActionType = payActionType;
    }

    public String getPayAgentCode() {
        return payAgentCode;
    }

    public void setPayAgentCode(String payAgentCode) {
        this.payAgentCode = payAgentCode;
    }

    public String getDeviceGuid() {
        return deviceGuid;
    }

    public void setDeviceGuid(String deviceGuid) {
        this.deviceGuid = deviceGuid;
    }

    /**
     * @return the reservationId
     */
    public String getReservationId() {
        return reservationId;
    }

    /**
     * @param reservationId the reservationId to set
     */
    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    /**
     * @return the payAgentUrl
     */
    public String getPayAgentUrl() {
        return payAgentUrl;
    }

    /**
     * @param payAgentUrl the payAgentUrl to set
     */
    public void setPayAgentUrl(String payAgentUrl) {
        this.payAgentUrl = payAgentUrl;
    }

    /**
     * @return the terminalId
     */
    public String getTerminalId() {
        return terminalId;
    }

    /**
     * @param terminalId the terminalId to set
     */
    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    /**
     * @return the deviceHandlerId
     */
    public String getDeviceHandlerId() {
        return deviceHandlerId;
    }

    /**
     * @param deviceHandlerId the deviceHandlerId to set
     */
    public void setDeviceHandlerId(String deviceHandlerId) {
        this.deviceHandlerId = deviceHandlerId;
    }

    /**
     * @return the connectedToDefaultFolio
     */
    public boolean isConnectedToDefaultFolio() {
        return connectedToDefaultFolio;
    }

    /**
     * @param connectedToDefaultFolio the connectedToDefaultFolio to set
     */
    public void setConnectedToDefaultFolio(boolean connectedToDefaultFolio) {
        this.connectedToDefaultFolio = connectedToDefaultFolio;
    }

    public boolean isAttachToAccount() {
        return attachToAccount;
    }

    public void setAttachToAccount(boolean attachToAccount) {
        this.attachToAccount = attachToAccount;
    }

    public boolean isMakeDefaultOnAccount() {
        return makeDefaultOnAccount;
    }

    public void setMakeDefaultOnAccount(boolean makeDefaultOnAccount) {
        this.makeDefaultOnAccount = makeDefaultOnAccount;
    }

    public boolean isAttachToProfile() {
        return attachToProfile;
    }

    public void setAttachToProfile(boolean attachToProfile) {
        this.attachToProfile = attachToProfile;
    }

    public boolean isMakeDefaultOnProfile() {
        return makeDefaultOnProfile;
    }

    public void setMakeDefaultOnProfile(boolean makeDefaultOnProfile) {
        this.makeDefaultOnProfile = makeDefaultOnProfile;
    }

    public boolean isThirdPartyPay() {
        return thirdPartyPay;
    }

    public void setThirdPartyPay(boolean thirdPartyPay) {
        this.thirdPartyPay = thirdPartyPay;
    }

    public boolean isDoNotDisclose() {
        return doNotDisclose;
    }

    public void setDoNotDisclose(boolean doNotDisclose) {
        this.doNotDisclose = doNotDisclose;
    }

    public boolean validate() {
        isValidRequest();

        switch (payActionType) {
            case ADD_PAYMENT_METHOD:
                isValidAddPaymentRequest();
                break;
            case CHECK_IN_DEFAULT_FOLIO:
                isValidCheckInForDefault();
            default:
                break;
        }

        return true;
    }

    /**
     * @return the payTransactions
     */
    public List<PaymentTransaction> getPayTransactions() {
        return payTransactions;
    }

    /**
     * @param payTransactions the payTransactions to set
     */
    public void setPayTransactions(List<PaymentTransaction> payTransactions) {
        this.payTransactions = payTransactions;
    }

    /**
     * @return the reservationConfirmationNumber
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * @param reservationConfirmationNumber the reservationConfirmationNumber to set
     */
    public void setInvoiceNumber(String reservationConfirmationNumber) {
        this.invoiceNumber = reservationConfirmationNumber;
    }

    public String getPantryName() {
        return pantryName;
    }

    public void setPantryName(String pantryName) {
        this.pantryName = pantryName;
    }

    private void isValidRequest() {
        if (deviceGuid == null || (accountId == null && profileId == null && payActionType != PayActionType.BOOK) ||
              terminalId == null || payActionType == null || payAgentCode == null || payAgentUrl == null) {
            throwException();
        }
    }

    private void isValidCheckInForDefault() {
        if (accountId == null || reservationId == null) {
            throwException();
        }
    }

    private void isValidAddPaymentRequest() {
        if (
            // Third Party payment method can't be set to default at account or folio level
              (thirdPartyPay && (makeDefaultOnAccount || connectedToDefaultFolio)) ||
                    // can't make default on account or folio if not attaching to account
                    (!attachToAccount && (makeDefaultOnAccount || connectedToDefaultFolio)) ||
                    // can't make default on profile if not attaching to profile
                    (!attachToProfile && makeDefaultOnProfile) ||
                    // can't attach to profile if no profile id is provided
                    (attachToProfile && profileId == null)) {
            throwException();
        }
    }

    private void throwException() {
        throw accountException(AccountErrorCode.REQUEST_INVALID)
              .asininePayload(ServiceError.CLIENT_INVALID_REQUEST, Status.NOT_FOUND).buildCompatible();
    }
}