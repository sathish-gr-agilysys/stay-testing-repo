/*
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.events;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.annotation.Transient;

import com.agilysys.pms.account.model.Balance;

public class RemoveInvoiceLineItemsEvent extends InvoiceBalanceChangeEvent {
    private Set<String> folioLineItemIds;

    public RemoveInvoiceLineItemsEvent() {}

    public RemoveInvoiceLineItemsEvent(Set<String> folioLineItemIds, List<Map<String, Object>> historyMetadata,
          Balance balance) {
        super(historyMetadata, balance);
        this.folioLineItemIds = folioLineItemIds;
    }

    public Set<String> getFolioLineItemIds() {
        return folioLineItemIds;
    }

    @Transient
    @Override
    public String getDisplayName() {
        return "Items removed from invoice.";
    }

    @Override
    public List<String> getHistoryMessages() {
        if (historyMetadata.isEmpty()) {
            return Collections.singletonList(getDisplayName());
        } else {
            List<String> historyMessages = new LinkedList<>();
            historyMetadata.forEach(metadata -> {
                String displayDate =
                      metadata.get("displayDate") != null ? metadata.get("displayDate").toString() : null;
                String itemName = metadata.get("itemName") != null ? metadata.get("itemName").toString() : null;
                String itemBalance =
                      metadata.get("lineItemBalance") != null ? metadata.get("lineItemBalance").toString() : null;
                historyMessages.add(String
                      .format("Item removed from invoice.  [Date: %s, Description: %s, Total: %s]", displayDate,
                            itemName, itemBalance));
            });
            return historyMessages;
        }
    }

    @Override
    public String getEventType() {
        return "Item Remove";
    }
}