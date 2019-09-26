/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.pms.common.model.export.WarehouseType;

public enum AccountWarehouseType implements WarehouseType {
    ACCOUNTS,
    LEDGER_TRANSACTIONS,
    RECURRING_CHARGES,
    REVENUE;
}
