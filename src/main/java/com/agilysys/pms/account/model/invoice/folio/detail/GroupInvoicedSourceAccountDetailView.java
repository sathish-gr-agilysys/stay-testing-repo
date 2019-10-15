/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.invoice.folio.detail;

import com.agilysys.pms.account.model.invoice.folio.GroupInvoicedSourceAccountFolioView;

public class GroupInvoicedSourceAccountDetailView
      extends GroupInvoicedSourceAccountFolioView<InvoiceFolioLineDetailView, InvoicedSourceAccountDetailView> {
    private String referenceId;
    private String sourceAccountName;
    private String sourceAccountType;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getSourceAccountName() {
        return sourceAccountName;
    }

    public void setSourceAccountName(String sourceAccountName) {
        this.sourceAccountName = sourceAccountName;
    }

    public String getSourceAccountType() {
        return sourceAccountType;
    }

    public void setSourceAccountType(String sourceAccountType) {
        this.sourceAccountType = sourceAccountType;
    }
}
