/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Map;

import com.agilysys.platform.communication.model.EmailDeliveryDetail;

public class BatchFolioInvoiceRequest {

    private List<String> accountIds;

    private Map<String, EmailDeliveryDetail> emailDeliveryDetailByAccountId;

    public List<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }

    public Map<String, EmailDeliveryDetail> getEmailDeliveryDetailByAccountId() {
        return emailDeliveryDetailByAccountId;
    }

    public void setEmailDeliveryDetailByAccountId(Map<String, EmailDeliveryDetail> emailDeliveryDetailByAccountId) {
        this.emailDeliveryDetailByAccountId = emailDeliveryDetailByAccountId;
    }
}
