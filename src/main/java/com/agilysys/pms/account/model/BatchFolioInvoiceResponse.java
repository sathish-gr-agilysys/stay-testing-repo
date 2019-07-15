/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

public class BatchFolioInvoiceResponse {

    private List<String> emailFailedReservations;
    private int emailSuccessCount;
    private int emailFailureCount;

    public BatchFolioInvoiceResponse() {}

    public BatchFolioInvoiceResponse(List<String> emailFailedReservations, int emailSuccessCount,
          int emailFailureCount) {
        this.emailFailedReservations = emailFailedReservations;
        this.emailSuccessCount = emailSuccessCount;
        this.emailFailureCount = emailFailureCount;
    }

    public List<String> getEmailFailedReservations() {
        return emailFailedReservations;
    }

    public void setEmailFailedReservations(List<String> emailFailedReservations) {
        this.emailFailedReservations = emailFailedReservations;
    }

    public int getEmailSuccessCount() {
        return emailSuccessCount;
    }

    public void setEmailSuccessCount(int emailSuccessCount) {
        this.emailSuccessCount = emailSuccessCount;
    }

    public int getEmailFailureCount() {
        return emailFailureCount;
    }

    public void setEmailFailureCount(int emailFailureCount) {
        this.emailFailureCount = emailFailureCount;
    }
}
