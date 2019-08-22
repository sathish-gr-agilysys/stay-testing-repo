/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

public class PantryItemDetails {
    private String description;
    private String itemId;
    private BigDecimal price;
    private BigDecimal defaultPrice;
    private int quantity;

    public PantryItemDetails() {}
    public PantryItemDetails(String itemId, String description, BigDecimal price, int quantity) {
        this.itemId = itemId;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }
    public PantryItemDetails(String itemId, String description, BigDecimal price, int quantity,
          BigDecimal defaultPrice) {
        this(itemId, description, price, quantity);
        this.defaultPrice = defaultPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(BigDecimal defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return (this.getPrice().multiply(BigDecimal.valueOf(this.getQuantity())));
    }
}
