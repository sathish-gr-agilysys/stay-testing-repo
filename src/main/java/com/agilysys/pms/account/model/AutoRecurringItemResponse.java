package com.agilysys.pms.account.model;

public class AutoRecurringItemResponse extends AutoRecurringItem {
    private int quantity;

    public AutoRecurringItemResponse() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
