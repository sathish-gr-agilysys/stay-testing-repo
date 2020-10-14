/**
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

public class GroupRevenueReportItem extends RevenueReportItem {
    private String roomTypeCode;
    private String transactionItemCode;
    private String transactionItemName;
    private String transactionCategoryCode;
    private String transactionCategoryName;
    private BigDecimal taxAmount;
    private Boolean reverseTax;
    private String subcategoryId;

    public GroupRevenueReportItem() {
        taxAmount = new BigDecimal(0);
    }

    public GroupRevenueReportItem(GroupRevenueReportItem revenueReportItem) {
        super(revenueReportItem);
    }

    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    public void setRoomTypeCode(String roomTypeCode) {
        this.roomTypeCode = roomTypeCode;
    }

    public String getTransactionItemCode() { return transactionItemCode; }

    public void setTransactionItemCode(String transactionItemCode) {
        this.transactionItemCode = transactionItemCode;
    }

    public String getTransactionItemName() {
        return transactionItemName;
    }

    public void setTransactionItemName(String transactionItemName) {
        this.transactionItemName = transactionItemName;
    }

    public String getTransactionCategoryCode() { return transactionCategoryCode; }

    public void setTransactionCategoryCode(String transactionCategoryCode) {
        this.transactionCategoryCode = transactionCategoryCode;
    }

    public String getTransactionCategoryName() { return transactionCategoryName; }

    public void setTransactionCategoryName(String transactionCategoryName) {
        this.transactionCategoryName = transactionCategoryName;
    }

    public BigDecimal getTaxAmount() { return taxAmount; }

    public void setTaxAmount(BigDecimal taxAmount) { this.taxAmount = taxAmount; }

    public Boolean getReverseTax() { return reverseTax; }

    public void setReverseTax(Boolean reverseTax) { this.reverseTax = reverseTax; }

    public String getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }
}
