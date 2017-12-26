/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

public enum TransactionItemType {
    Transaction("setup/accounts/transactionItems", TransactionItem.class),
    Inventory("setup/accounts/InventoryItems", InventoryItem.class);

    private final Class clazz;
    private final String path;

    TransactionItemType(String path, Class clazz) {
        this.path = path;
        this.clazz = clazz;
    }

    public Class getClazz() {
        return clazz;
    }

    public String getPath() {
        return path;
    }
}
