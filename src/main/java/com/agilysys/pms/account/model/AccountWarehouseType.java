/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import static com.agilysys.pms.common.exceptions.ExceptionFactory.commonException;

import com.agilysys.pms.common.exceptions.common.CommonContextKey;
import com.agilysys.pms.common.exceptions.common.CommonErrorCode;
import com.agilysys.pms.common.model.export.WarehouseType;

public enum AccountWarehouseType implements WarehouseType {
    ACCOUNTS,
    LEDGER_TRANSACTIONS,
    RECURRING_CHARGES,
    REVENUE;

    public static AccountWarehouseType fromString(String s) {
        try {
            return valueOf(s.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw commonException(CommonErrorCode.WAREHOUSE_TYPE_UNSUPPORTED).put(CommonContextKey.TYPE, s)
                  .buildCompatible();
        }
    }
}
