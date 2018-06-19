/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.util.List;
import java.util.Map;

import org.joda.time.LocalDate;

import com.agilysys.platform.common.json.schema.MaxLengthRestriction;
import com.agilysys.platform.common.json.schema.MinLengthRestriction;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * View model object used to describe transfer charges data
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LineItemTransfer {
    @JsonProperty(required = true)
    private String destinationAccountId;

    private String destinationFolioId;

    @MaxLengthRestriction(250)
    private String reason;
    private String reference;

    @JsonProperty(required = true)
    @MinLengthRestriction(1)
    private List<String> folioLineItemIds;
    private Map<String, String> transactionMessageAttributes;
    private LocalDate postingDate;

    public String getDestinationAccountId() {
        return destinationAccountId;
    }

    public void setDestinationAccountId(String destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
    }

    public String getDestinationFolioId() {
        return destinationFolioId;
    }

    public void setDestinationFolioId(String destinationFolioId) {
        this.destinationFolioId = destinationFolioId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<String> getFolioLineItemIds() {
        return folioLineItemIds;
    }

    public void setFolioLineItemIds(List<String> folioLineItemIds) {
        this.folioLineItemIds = folioLineItemIds;
    }

    public Map<String, String> getTransactionMessageAttributes() {
        return transactionMessageAttributes;
    }

    public void setTransactionMessageAttributes(Map<String, String> transactionMessageAttributes) {
        this.transactionMessageAttributes = transactionMessageAttributes;
    }

    /**
     * @return Date for the line item transfer posting or null if using current property date
     */
    public LocalDate getPostingDate() {
        return postingDate;
    }

    /**
     * Optional - Sets the date to post the line item transfer to if posting to a previous fiscal day.  Special
     * permissions are required to set this to a value other than the current property date.
     *
     * @param postingDate
     */
    public void setPostingDate(LocalDate postingDate) {
        this.postingDate = postingDate;
    }
}
