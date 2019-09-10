/**
 *
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

/**
 * @author shahram.pourdashti
 */
public class TransactionReportItem {
    private String id;
    private String type;
    private BigDecimal amount;
    private int quantity;
    private String categoryId;
    private String subcategoryId;
    private String glCodeTemplate;
    private String itemId;
    private String description;
    private String userId;
    private String reservationId;
    private String accountId;
    private LocalDate displayDate;
    private LocalDate postingPropertyDate;
    private DateTime postingCalendarDateTime;
    private String accountType;
    private String referenceId;
    private String refundReferenceId;
    // this can reference a folioLine id that originated the tax like a charge, correction, transferred charge
    private String taxReferenceId;
    private String accountName;
    private TransferSummary transferSummary;
    private String reason;
    private boolean isRoomRevenue;
    private String autoRecurringItemId;
    private String sourceId;
    private String mealPeriodId;
    private List<PantryItemDetails> pantryItemDetails;
    private DateTime createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getMealPeriodId() {
        return mealPeriodId;
    }

    public void setMealPeriodId(String mealPeriodId) {
        this.mealPeriodId = mealPeriodId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getGlCodeTemplate() {
        return glCodeTemplate;
    }

    public void setGlCodeTemplate(String glCodeTemplate) {
        this.glCodeTemplate = glCodeTemplate;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public LocalDate getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(LocalDate displayDate) {
        this.displayDate = displayDate;
    }

    public LocalDate getPostingPropertyDate() {
        return postingPropertyDate;
    }

    public void setPostingPropertyDate(LocalDate postingPropertyDate) {
        this.postingPropertyDate = postingPropertyDate;
    }

    public DateTime getPostingCalendarDateTime() {
        return postingCalendarDateTime;
    }

    public void setPostingCalendarDateTime(DateTime postingCalendarDateTime) {
        this.postingCalendarDateTime = postingCalendarDateTime;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getRefundReferenceId() {
        return refundReferenceId;
    }

    public void setRefundReferenceId(String refundReferenceId) {
        this.refundReferenceId = refundReferenceId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public TransferSummary getTransferSummary() {
        return transferSummary;
    }

    public void setTransferSummary(TransferSummary transferSummary) {
        this.transferSummary = transferSummary;
    }

    public String getTaxReferenceId() {
        return taxReferenceId;
    }

    public void setTaxReferenceId(String taxReferenceId) {
        this.taxReferenceId = taxReferenceId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isRoomRevenue() {
        return isRoomRevenue;
    }

    public void setRoomRevenue(boolean isRoomRevenue) {
        this.isRoomRevenue = isRoomRevenue;
    }

    public String getAutoRecurringItemId() {
        return autoRecurringItemId;
    }

    public void setAutoRecurringItemId(String autoRecurringItemId) {
        this.autoRecurringItemId = autoRecurringItemId;
    }

    public List<PantryItemDetails> getPantryItemDetails() {
        return pantryItemDetails;
    }

    public void setPantryItemDetails(List<PantryItemDetails> pantryItemDetails) {
        this.pantryItemDetails = pantryItemDetails;
    }

    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }
}
