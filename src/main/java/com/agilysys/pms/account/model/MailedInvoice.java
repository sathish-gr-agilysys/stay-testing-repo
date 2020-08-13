/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Set;

public class MailedInvoice {
    private Set<String> invoiceIdSet;
    private List<String> emailIds;

    public MailedInvoice() {
    }

    public Set<String> getInvoiceIdSet() {
        return invoiceIdSet;
    }

    public void setInvoiceIdSet(Set<String> invoiceIdSet) {
        this.invoiceIdSet = invoiceIdSet;
    }

    public List<String> getEmailIds() {
        return emailIds;
    }

    public void setEmailIds(List<String> email) {
        this.emailIds = email;
    }
}
