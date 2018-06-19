/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.events;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.annotation.Transient;

public class AddInvoiceLineItemsEvent extends InvoiceBalanceChangeEvent {
    private Set<String> folioLineItemIds;

    public AddInvoiceLineItemsEvent() { super(); }

    public AddInvoiceLineItemsEvent(Set<String> folioLineItemIds, List<Map<String, Object>> historyMetadata,
          boolean closed) {
        super(historyMetadata, closed);

        this.folioLineItemIds = folioLineItemIds;
    }

    public Set<String> getFolioLineItemIds() {
        return folioLineItemIds;
    }

    @Override
    public long getEventVersion() {
        return 0;
    }

    @Transient
    @Override
    public String getDisplayName() {
        return "Items added to invoice.";
    }

    @Override
    public List<String> getHistoryMessages() {
        if (historyMetadata.isEmpty()) {
            return Arrays.asList(getDisplayName());
        }

        List<String> historyMessages = new LinkedList<>();
        historyMetadata.forEach(metadata -> {
            String displayDate = metadata.get("displayDate") != null ? metadata.get("displayDate").toString() : null;
            String itemName = metadata.get("itemName") != null ? metadata.get("itemName").toString() : null;
            String itemBalance =
                  metadata.get("lineItemBalance") != null ? metadata.get("lineItemBalance").toString() : null;
            String sourceAccountId =
                  metadata.get("sourceAccountId") != null ? metadata.get("sourceAccountId").toString() : null;
            historyMessages.add(String
                  .format("Item added to invoice.  [Date: %s, Description: %s, Total: %s, Origin Account: %s]",
                        displayDate, itemName, itemBalance, sourceAccountId));
        });

        return historyMessages;
    }
}
