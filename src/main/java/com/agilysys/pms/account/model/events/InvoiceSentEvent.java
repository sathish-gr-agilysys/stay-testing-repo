/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.events;

import java.util.Collections;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Transient;

public class InvoiceSentEvent extends InvoiceEvent {
    private boolean isEmail;
    private String userId;
    private DateTime deliveryDateTime;
    private List<String> emailIds;

    public InvoiceSentEvent() {

    }

    public InvoiceSentEvent(boolean isEmail, String userId, DateTime deliveryDateTime) {
        this.isEmail = isEmail;
        this.userId = userId;
        this.deliveryDateTime = deliveryDateTime;
    }

    public InvoiceSentEvent(boolean isEmail, String userId, DateTime deliveryDateTime, List<String> emailIds) {
        this.isEmail = isEmail;
        this.userId = userId;
        this.deliveryDateTime = deliveryDateTime;
        this.emailIds = emailIds;
    }

    public boolean isEmail() {
        return isEmail;
    }

    public boolean isPrinted() {
        return !isEmail;
    }

    public List<String> getEmailIds() {
        return emailIds;
    }

    public void setEmailIds(List<String> emailIds) {
        this.emailIds = emailIds;
    }

    public String getUserId() {
        return userId;
    }

    public DateTime getDeliveryDateTime() {
        return deliveryDateTime;
    }

    @Override
    public long getEventVersion() {
        return 0;
    }

    @Transient
    @Override
    public String getDisplayName() {
        return this.isEmail ? "Invoice Has Been Emailed" : "Invoice Has Been Printed";
    }

    @Override
    public List<String> getHistoryMessages() {
        if (isEmail) {
            return Collections.singletonList("Sent by email.");
        } else {
            return Collections.singletonList("Printed and sent.");

        }
    }
}
