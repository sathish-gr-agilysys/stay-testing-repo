/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.events;

import java.util.*;

import org.springframework.data.annotation.Transient;

import com.agilysys.pms.account.model.Balance;

public class AddInvoiceLineItemsEvent extends InvoiceBalanceChangeEvent {
    private Set<String> folioLineItemIds;

    public AddInvoiceLineItemsEvent() {
    }

    public AddInvoiceLineItemsEvent(Set<String> folioLineItemIds, List<Map<String, Object>> historyMetadata,
          Balance balance) {
        super(historyMetadata, balance);
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
            return Collections.singletonList(getDisplayName());
        }

        List<String> historyMessages = new LinkedList<>();
        historyMetadata.forEach(metadata -> {
            String displayDate = metadata.get("displayDate") != null ? metadata.get("displayDate").toString() : null;
            String itemName = metadata.get("itemName") != null ? metadata.get("itemName").toString() : null;
            String itemBalance =
                  metadata.get("lineItemBalance") != null ? metadata.get("lineItemBalance").toString() : null;
            historyMessages.add(String
                  .format("Item added to invoice.  [Date: %s, Description: %s, Total: %s]", displayDate, itemName,
                        itemBalance));
        });

        return historyMessages;
    }
}
