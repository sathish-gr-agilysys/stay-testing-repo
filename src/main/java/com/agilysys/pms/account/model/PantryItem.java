/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import java.math.BigDecimal;

import com.agilysys.common.model.statuses.PropertyConfigItemStatus.CanonicalId;
import com.agilysys.platform.common.json.schema.MaxLengthRestriction;
import com.agilysys.platform.common.json.schema.MinLengthRestriction;
import com.agilysys.pms.common.audit.EntityTypes;
import com.agilysys.pms.common.audit.annotation.AuditEntity;
import com.agilysys.pms.common.audit.annotation.AuditField;
import com.agilysys.pms.common.model.annotation.DataPortReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@AuditEntity(EntityTypes.PANTRY_ITEM)
public class PantryItem extends AccountingObjectBase {
    private static final String DISPLAY_NAME = "Pantry Items";

    @JsonProperty(required = true)
    private BigDecimal price;

    @JsonProperty(required = true)
    @AuditField(name = "transactionItem", references = EntityTypes.TRANSACTION_ITEM)
    @DataPortReference(name = "transactionItemCode", type = { TransactionItem.class })
    private String transactionItemId;

    private CanonicalId status;

    @MinLengthRestriction(4)
    @MaxLengthRestriction(5)
    private String plu;
    private int order;
    private Boolean requireInventory = Boolean.FALSE;
    private int initialQuantity;
    private int availableQuantity;

    public PantryItem() {}

    public PantryItem(PantryItem pantryItem) {
        super(pantryItem);
        this.price = pantryItem.getPrice();
        this.status = pantryItem.getStatus();
        this.plu = pantryItem.getPlu();
        this.order = pantryItem.getOrder();
        this.transactionItemId = pantryItem.getTransactionItemId();
        if (pantryItem.getRequireInventory() == null) {
            this.requireInventory = Boolean.FALSE;
        } else {
            this.requireInventory = pantryItem.getRequireInventory();
        }
        this.initialQuantity = pantryItem.getInitialQuantity();
        this.availableQuantity = pantryItem.getAvailableQuantity();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public CanonicalId getStatus() {
        return status;
    }

    public void setStatus(CanonicalId status) {
        this.status = status;
    }

    public Boolean getRequireInventory() {
        return requireInventory;
    }

    public void setRequireInventory(Boolean requireInventory) {
        this.requireInventory = requireInventory;
    }

    public int getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(int initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }
}
