/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.api;

import com.agilysys.pms.account.model.AccountAggregateType;
import com.agilysys.pms.account.model.AccountWarehouseType;
import com.agilysys.pms.common.api.export.AggregationWarehouseMaintenanceInterface;

public interface AccountWarehouseMaintenanceInterface
      extends AggregationWarehouseMaintenanceInterface<AccountAggregateType, AccountWarehouseType> {}
