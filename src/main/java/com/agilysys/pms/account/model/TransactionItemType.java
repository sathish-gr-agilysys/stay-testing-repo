/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public enum TransactionItemType {
    TRANSACTION("setup/accounts/transactionItems", TransactionItem.class),
    INVENTORY("setup/accounts/inventoryItems", InventoryItem.class);

    private final String path;
    private final Class clazz;

    TransactionItemType(String path, Class clazz) {
        this.path = path;
        this.clazz = clazz;
    }

    public String getPath() {
        return path;
    }

    public Class getClazz() {
        return clazz;
    }
}
