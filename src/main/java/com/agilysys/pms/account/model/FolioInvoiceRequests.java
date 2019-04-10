/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

public class FolioInvoiceRequests {

    private List<String> accountIds;
    private List<FolioInvoiceRequest> folioInvoiceRequests;

    public List<FolioInvoiceRequest> getFolioInvoiceRequests() {
        return folioInvoiceRequests;
    }

    public void setFolioInvoiceRequests(List<FolioInvoiceRequest> folioInvoiceRequests) {
        this.folioInvoiceRequests = folioInvoiceRequests;
    }

    public List<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }
}
