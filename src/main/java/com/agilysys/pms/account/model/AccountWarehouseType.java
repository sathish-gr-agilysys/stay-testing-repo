/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.pms.common.model.export.WarehouseType;

public enum AccountWarehouseType implements WarehouseType {
    ACCOUNTS,
    CATEGORIES,
    LEDGER_TRANSACTIONS,
    RECURRING_CHARGES,
    REVENUE,
    SUBCATEGORIES;

    // This is implicitly used by Jersey when converting @PathParam/@QueryParam
    public static AccountWarehouseType fromString(String s) {
        try {
            return valueOf(s.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw WarehouseType.warehouseTypeUnsupported(s);
        }
    }
}