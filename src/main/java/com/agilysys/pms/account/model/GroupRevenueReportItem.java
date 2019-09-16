/**
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public class GroupRevenueReportItem extends RevenueReportItem {
    private String roomTypeCode;
    private String transactionItemCode;
    private String transactionItemName;
    private String transactionCategoryCode;
    private String transactionCategoryName;

    public GroupRevenueReportItem() {}

    public GroupRevenueReportItem(RevenueReportItem revenueReportItem) {
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

    public String getTransactionItemName() { return transactionItemName;
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
}
