package com.agilysys.pms.account.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupItemView {

    private String id;
    private String transactionId;
    private String transactionType;
    private String transactionDestinationAccountId;
    private String postingPropertyDate;
    private String postingCalendarDateTime;
    private String displayDate;
    private String reservationId;
    private String accountId;
    private String folioId;
    private String userId;
    private GroupSummary groupSummary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionDestinationAccountId() {
        return transactionDestinationAccountId;
    }

    public void setTransactionDestinationAccountId(String transactionDestinationAccountId) {
        this.transactionDestinationAccountId = transactionDestinationAccountId;
    }

    public String getPostingPropertyDate() {
        return postingPropertyDate;
    }

    public void setPostingPropertyDate(String postingPropertyDate) {
        this.postingPropertyDate = postingPropertyDate;
    }

    public String getPostingCalendarDateTime() {
        return postingCalendarDateTime;
    }

    public void setPostingCalendarDateTime(String postingCalendarDateTime) {
        this.postingCalendarDateTime = postingCalendarDateTime;
    }

    public String getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(String displayDate) {
        this.displayDate = displayDate;
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

    public String getFolioId() {
        return folioId;
    }

    public void setFolioId(String folioId) {
        this.folioId = folioId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public GroupSummary getGroupSummary() {
        return groupSummary;
    }

    public void setGroupSummary(GroupSummary groupSummary) {
        this.groupSummary = groupSummary;
    }
}
