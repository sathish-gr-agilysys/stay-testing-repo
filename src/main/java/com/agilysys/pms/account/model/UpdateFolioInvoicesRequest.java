/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;

public class UpdateFolioInvoicesRequest {

    private List<FolioInvoice> folioInvoices;

    public UpdateFolioInvoicesRequest() {
    }

    public UpdateFolioInvoicesRequest(List<FolioInvoice> folioInvoices) {
        this.folioInvoices = folioInvoices;
    }

    public List<FolioInvoice> getFolioInvoices() {
        return folioInvoices;
    }

    public void setFolioInvoices(List<FolioInvoice> folioInvoices) {
        this.folioInvoices = folioInvoices;
    }
}
