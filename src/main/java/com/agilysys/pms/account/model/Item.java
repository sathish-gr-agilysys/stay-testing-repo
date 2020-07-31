package com.agilysys.pms.account.model;

import java.math.BigDecimal;

public class Item {
    private String itemName;
    private BigDecimal amount;

    public Item() {

    }

    public Item(String itemName, BigDecimal amount) {
        this.itemName = itemName;
        this.amount = amount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
