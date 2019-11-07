/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.model;

import com.agilysys.pms.common.model.export.AggregateType;

public enum AccountAggregateType implements AggregateType {
    REVENUE;

    // This is implicitly used by Jersey when converting @PathParam/@QueryParam
    public static AccountAggregateType fromString(String s) {
        try {
            return valueOf(s.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw AggregateType.aggregateTypeUnsupported(s);
        }
    }
}
