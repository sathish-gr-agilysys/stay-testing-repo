/*
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.LocalDate;

import com.agilysys.common.model.rate.AllowanceCombination;
import com.agilysys.common.model.rate.CompInfo;
import com.agilysys.common.model.rate.ComponentType;
import com.agilysys.common.model.rate.RoomChargePostingType;
import com.agilysys.platform.common.json.schema.MaxLengthRestriction;
import com.agilysys.platform.common.json.schema.MinValueRestriction;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Base class for different transaction types.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Transaction {
    @JsonProperty(required = true)
    protected String accountId;
    @JsonProperty(required = true)
    protected BigDecimal amount;
    protected String callType;
    protected CompInfo compInfo;
    protected CurrencyExchangeDetails currencyExchangeDetails;
    protected RoomChargePostingType roomChargePostingType;
    protected ComponentType componentType;
    protected String descriptionOverride;
    protected String folioId;
    protected BigDecimal freeAllowanceAmount = BigDecimal.ZERO;
    protected Boolean ignoreRules = true;
    protected boolean invalid;
    @JsonProperty(required = true)
    protected String itemId;
    public static final String ITEM_ID_FIELD = "itemId";
    protected Boolean pantryItem;
    protected List<PantryItemDetails> pantryItems;
    protected String parentId;
    protected String petDisplayName;
    protected String chargeTypeDisplayName;
    protected LocalDate postingDate;
    protected LocalDate displayDate;
    @MinValueRestriction(1)
    protected int quantity = 1;
    @MaxLengthRestriction(250)
    protected String rateChangeComment;
    @MaxLengthRestriction(250)
    protected String reason;
    protected String reference;
    protected String sourceId;
    protected String terminalId;
    protected String gatewayType;
    protected boolean giftCard;
    protected String giftCardNumber;
    protected boolean excludeTax;
    protected boolean arDeposit;
    protected boolean routingChargeAlreadyPosted;
    protected String referenceNumber;
    protected String authCode;
    protected String cardHolderName;
    protected Boolean depositPaymentAtBooking;
    protected String lineItemId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount.setScale(2, RoundingMode.HALF_UP);
    }

    public CompInfo getCompInfo() {
        return compInfo;
    }

    public void setCompInfo(CompInfo compInfo) {
        this.compInfo = compInfo;
    }

    public RoomChargePostingType getRoomChargePostingType() {
        return roomChargePostingType;
    }

    public void setRoomChargePostingType(RoomChargePostingType roomChargePostingType) {
        this.roomChargePostingType = roomChargePostingType;
    }

    public ComponentType getComponentType() {
        return componentType;
    }

    public void setComponentType(ComponentType componentType) {
        this.componentType = componentType;
    }

    public String getDescriptionOverride() {
        return descriptionOverride;
    }

    public void setDescriptionOverride(String descriptionOverride) {
        this.descriptionOverride = descriptionOverride;
    }

    public String getFolioId() {
        return folioId;
    }

    public void setFolioId(String folioId) {
        this.folioId = folioId;
    }

    public Boolean getIgnoreRules() {
        return (ignoreRules != null ? ignoreRules : false);
    }

    public void setIgnoreRules(Boolean ignoreRules) {
        this.ignoreRules = ignoreRules;
    }

    public boolean isInvalid() {
        return invalid;
    }

    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getPetDisplayName() {
        return petDisplayName;
    }

    public void setPetDisplayName(String petDisplayName) {
        this.petDisplayName = petDisplayName;
    }

    public String getChargeTypeDisplayName() {
        return chargeTypeDisplayName;
    }

    public void setChargeTypeDisplayName(String chargeTypeDisplayName) {
        this.chargeTypeDisplayName = chargeTypeDisplayName;
    }

    /**
     * @return Date for the transaction posting or null if using current property date
     */
    public LocalDate getPostingDate() {
        return postingDate;
    }

    /**
     * Optional - Sets the date to post the transaction to if posting to a previous fiscal day.  Special permissions are
     * required to set this to a value other than the current property date.
     */
    public void setPostingDate(LocalDate postingDate) {
        this.postingDate = postingDate;
    }

    public LocalDate getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(LocalDate displayDate) {
        this.displayDate = displayDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRateChangeComment() {
        return rateChangeComment;
    }

    public void setRateChangeComment(String rateChangeComment) {
        this.rateChangeComment = rateChangeComment;
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

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getCallType() { return callType; }

    public void setCallType(String callType) { this.callType = callType; }

    public BigDecimal getFreeAllowanceAmount() { return freeAllowanceAmount; }

    public void setFreeAllowanceAmount(BigDecimal freeAllowanceAmount) {
        this.freeAllowanceAmount = freeAllowanceAmount;
    }

    public String getGatewayType() {
        return gatewayType;
    }

    public void setGatewayType(String gatewayType) {
        this.gatewayType = gatewayType;
    }

    public String getGiftCardNumber() {
        return giftCardNumber;
    }

    public void setGiftCardNumber(String giftCardNumber) {
        this.giftCardNumber = giftCardNumber;
    }

    public boolean isGiftCard() {
        return giftCard;
    }

    public void setGiftCard(boolean giftCard) {
        this.giftCard = giftCard;
    }

    public List<PantryItemDetails> getPantryItems() {
        return pantryItems;
    }

    public void setPantryItems(List<PantryItemDetails> pantryItems) {
        this.pantryItems = pantryItems;
    }

    public Boolean getPantryItem() {
        return pantryItem;
    }

    public void setPantryItem(Boolean pantryItem) {
        this.pantryItem = pantryItem;
    }

    public boolean isExcludeTax() {
        return excludeTax;
    }

    public void setExcludeTax(boolean excludeTax) {
        this.excludeTax = excludeTax;
    }

    public boolean isArDeposit() {
        return arDeposit;
    }

    public void setArDeposit(boolean arDeposit) {
        this.arDeposit = arDeposit;
    }

    public boolean isRoutingChargeAlreadyPosted() {
        return routingChargeAlreadyPosted;
    }

    public void setRoutingChargeAlreadyPosted(boolean routingChargeAlreadyPosted) {
        this.routingChargeAlreadyPosted = routingChargeAlreadyPosted;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public CurrencyExchangeDetails getCurrencyExchangeDetails() {
        return currencyExchangeDetails;
    }

    public void setCurrencyExchangeDetails(CurrencyExchangeDetails currencyExchangeDetails) {
        this.currencyExchangeDetails = currencyExchangeDetails;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public Boolean getDepositPaymentAtBooking() {
        return depositPaymentAtBooking;
    }

    public void setDepositPaymentAtBooking(Boolean depositPaymentAtBooking) {
        this.depositPaymentAtBooking = depositPaymentAtBooking;
    }

    public String getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(accountId).append(amount).append(folioId).append(ignoreRules).append(itemId)
              .append(postingDate).append(displayDate).append(reason).append(reference).append(sourceId)
              .append(terminalId).append(gatewayType).append(giftCardNumber).append(giftCard).append(excludeTax)
              .append(authCode).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) obj;

        return new EqualsBuilder().append(accountId, other.accountId).append(amount, other.amount)
              .append(folioId, other.folioId).append(ignoreRules, other.ignoreRules).append(itemId, other.itemId)
              .append(postingDate, other.postingDate).append(reason, other.reason).append(reference, other.reference)
              .append(sourceId, other.sourceId).append(terminalId, other.terminalId)
              .append(displayDate, other.displayDate).append(gatewayType, other.gatewayType)
              .append(giftCardNumber, other.giftCardNumber).append(giftCard, other.giftCard)
              .append(descriptionOverride, other.getDescriptionOverride()).append(excludeTax, other.isExcludeTax())
              .append(authCode, other.authCode).isEquals();
    }

    public AllowanceCombination toAllowanceCombination() {
        return null;
    }

    public boolean checkPosCharge() {
        return false;
    }
}
