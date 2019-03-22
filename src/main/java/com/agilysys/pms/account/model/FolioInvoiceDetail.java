/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

public class FolioInvoiceDetail {

    private String folioInvoiceNumber;
    private String folioName;
    private InvoiceStatus invoiceStatus;
    private BigDecimal folioBalance;
    private List<LineItemView> lineItemViews;
    private FolioInvoice folioInvoice;

    public String getFolioInvoiceNumber() {
        return folioInvoiceNumber;
    }

    public void setFolioInvoiceNumber(String folioInvoiceNumber) {
        this.folioInvoiceNumber = folioInvoiceNumber;
    }

    public String getFolioName() {
        return folioName;
    }

    public void setFolioName(String folioName) {
        this.folioName = folioName;
    }

    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public BigDecimal getFolioBalance() {
        return folioBalance;
    }

    public void setFolioBalance(BigDecimal folioBalance) {
        this.folioBalance = folioBalance;
    }

    public List<LineItemView> getLineItemViews() {
        return lineItemViews;
    }

    public void setLineItemViews(List<LineItemView> lineItemViews) {
        this.lineItemViews = lineItemViews;
    }

    public FolioInvoice getFolioInvoice() {
        return folioInvoice;
    }

    public void setFolioInvoice(FolioInvoice folioInvoice) {
        this.folioInvoice = folioInvoice;
    }
}
