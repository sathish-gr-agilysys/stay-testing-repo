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

@JsonIgnoreProperties(ignoreUnknown = true)
public class AmountTransfer {
    @JsonProperty(required = true)
    private String sourceFolioId;

    @JsonProperty(required = true)
    private String destinationAccountId;

    private String destinationFolioId;

    @JsonProperty(required = true)
    private BigDecimal amount;

    @MaxLengthRestriction(250)
    private String reason;

    private String reference;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getSourceFolioId() {
        return sourceFolioId;
    }

    public void setSourceFolioId(String sourceFolioId) {
        this.sourceFolioId = sourceFolioId;
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

    public Map<String, String> getTransactionMessageAttributes() {
        return transactionMessageAttributes;
    }

    public void setTransactionMessageAttributes(Map<String, String> transactionMessageAttributes) {
        this.transactionMessageAttributes = transactionMessageAttributes;
    }

    /**
     * @return Date for the transfer amount posting or null if using current property date
     */
    public LocalDate getPostingDate() {
        return postingDate;
    }

    /**
     * Optional - Sets the date to post the amount transfer to if posting to a previous fiscal day.  Special
     * permissions
     * are required to set this to a value other than the current property date.
     *
     * @param postingDate
     */
    public void setPostingDate(LocalDate postingDate) {
        this.postingDate = postingDate;
    }
}
