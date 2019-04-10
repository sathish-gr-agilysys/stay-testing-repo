/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.pms.account.model.AccountAttributes.PreferredCommunication;

public class CentralARView {
    private PreferredCommunication preferredCommunicationType;
    private String accountId;
    private String propertyId;
    private String invoiceNumber;
    private String emailAddress;

    public CentralARView() {
    }

    public CentralARView(PreferredCommunication preferredCommunicationType, String accountId, String propertyId,
          String invoiceNumber, String emailAddress) {
        this.preferredCommunicationType = preferredCommunicationType;
        this.accountId = accountId;
        this.propertyId = propertyId;
        this.invoiceNumber = invoiceNumber;
        this.emailAddress = emailAddress;
    }

    public PreferredCommunication getPreferredCommunicationType() {
        return preferredCommunicationType;
    }

    public void setPreferredCommunicationType(PreferredCommunication preferredCommunicationType) {
        this.preferredCommunicationType = preferredCommunicationType;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
