/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class FolioInvoiceUpdateRequest {

    private FolioInvoiceUpdateCategory folioInvoiceUpdateCategory;
    private FolioInvoice folioInvoice;

    public FolioInvoiceUpdateRequest() {
    }

    public FolioInvoiceUpdateRequest(FolioInvoiceUpdateCategory folioInvoiceUpdateCategory, FolioInvoice folioInvoice) {
        this.folioInvoiceUpdateCategory = folioInvoiceUpdateCategory;
        this.folioInvoice = folioInvoice;
    }

    public FolioInvoiceUpdateCategory getFolioInvoiceUpdateCategory() {
        return folioInvoiceUpdateCategory;
    }

    public void setFolioInvoiceUpdateCategory(FolioInvoiceUpdateCategory folioInvoiceUpdateCategory) {
        this.folioInvoiceUpdateCategory = folioInvoiceUpdateCategory;
    }

    public FolioInvoice getFolioInvoice() {
        return folioInvoice;
    }

    public void setFolioInvoice(FolioInvoice folioInvoice) {
        this.folioInvoice = folioInvoice;
    }
}
