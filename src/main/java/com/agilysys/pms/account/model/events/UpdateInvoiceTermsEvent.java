/**
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model.events;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Transient;

public class UpdateInvoiceTermsEvent extends InvoiceEvent {
    private int terms;

    public UpdateInvoiceTermsEvent(int terms, List<Map<String, Object>> historyMetadata) {
        super(historyMetadata);

        this.terms = terms;
    }

    public int getTerms() {
        return this.terms;
    }

    @Override
    public long getEventVersion() {
        return 0;
    }

    @Transient
    @Override
    public String getDisplayName() {
        return "Invoice Terms updated.";
    }

    @Override
    public List<String> getHistoryMessages() {
        String termsUpdatedMessage =
                (historyMetadata.isEmpty() || !historyMetadata.get(0).containsKey("previousTerms")) ?
                        String.format("Terms changed to %d days.", terms) :
                        String.format("Terms changed from %s days to %d days.",
                                historyMetadata.get(0).get("previousTerms").toString(), terms);

        return Collections.singletonList(termsUpdatedMessage);
    }
}
