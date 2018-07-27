/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

import org.joda.time.LocalDate;

public interface PosTransaction {
    String getAccountId();
    void setAccountId(String accountId);

    BigDecimal getAmount();
    void setAmount(BigDecimal amount);

    String getFolioId();
    void setFolioId(String folioId);

    Boolean getIgnoreRules();
    void setIgnoreRules(Boolean ignoreRules);

    String getItemId();
    void setItemId(String itemId);

    String getParentId();
    void setParentId(String parentId);

    LocalDate getPostingDate();
    void setPostingDate(LocalDate postingDate);

    int getQuantity();
    void setQuantity(int quantity);

    String getReason();
    void setReason(String reason);

    String getReceiptText();
    void setReceiptText(String receiptText);

    String getReference();
    void setReference(String reference);

    String getSourceId();
    void setSourceId(String sourceId);

    String getTerminalId();
    void setTerminalId(String terminalId);

    String getCheckNumber();
    void setCheckNumber(String checkNumber);
}
