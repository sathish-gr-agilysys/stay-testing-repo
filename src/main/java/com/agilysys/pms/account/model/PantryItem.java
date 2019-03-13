/**
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

import com.agilysys.pms.common.model.ObjectBase;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PantryItem extends ObjectBase {

    private String id;

    @JsonProperty(required = true)
    private String itemName;

    @JsonProperty(required = true)
    private String itemCode;

    @JsonProperty(required = true)
    private BigDecimal price;

    @JsonProperty(required = true)
    private String transactionItemId;

    private boolean status;
    private String plu;
    private int order;

    public PantryItem() {
    }

    public PantryItem(PantryItem pantryItem) {
        itemName = pantryItem.getItemName();
        itemCode = pantryItem.getItemCode();
        price = pantryItem.getPrice();
        status = pantryItem.getStatus();
        plu = pantryItem.getPlu();
        order = pantryItem.getOrder();
        transactionItemId = pantryItem.getTransactionItemId();
    }

    public String getItemName() {
        return itemName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPlu() {
        return plu;
    }

    public void setPlu(String plu) {
        this.plu = plu;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getTransactionItemId() {
        return transactionItemId;
    }

    public void setTransactionItemId(String transactionItemId) {
        this.transactionItemId = transactionItemId;
    }

}
