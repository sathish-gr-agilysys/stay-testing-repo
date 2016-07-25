/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.Map;

import org.joda.time.LocalDate;

import com.agilysys.platform.common.json.schema.MaxLengthRestriction;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * View model object used to describe adjustment and correction data
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LineItemAdjustment {
    public enum AdjustmentType {
        ADJUSTMENT,
        CORRECTION
    }

    @JsonProperty(required = true)
    private AdjustmentType type;

    @JsonProperty(required = true)
    private String folioLineItemId;

    @JsonProperty(required = true)
    private BigDecimal amount;

    @MaxLengthRestriction(250)
    private String reason;

    private String terminalId;

    private String reference;
    private Map<String, String> transactionMessageAttributes;
    private LocalDate postingDate;

    public AdjustmentType getType() {
        return type;
    }

    public void setType(AdjustmentType type) {
        this.type = type;
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

    public String getFolioLineItemId() {
        return folioLineItemId;
    }

    public void setFolioLineItemId(String folioLineItemId) {
        this.folioLineItemId = folioLineItemId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Map<String, String> getTransactionMessageAttributes() {
        return transactionMessageAttributes;
    }

    public void setTransactionMessageAttributes(Map<String, String> transactionMessageAttributes) {
        this.transactionMessageAttributes = transactionMessageAttributes;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    /**
     * @return Date for the adjustment or correction, or null if using current property date
     */
    public LocalDate getPostingDate() {
        return postingDate;
    }

    /**
     * Optional - Sets the date to post the adjustment or correction to if posting to a previous fiscal day.  Special
     * permissions are required to set this to a value other than the current property date.
     *
     * @param postingDate
     */
    public void setPostingDate(LocalDate postingDate) {
        this.postingDate = postingDate;
    }
}
