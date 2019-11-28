/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.AccountWarehouseMaintenanceInterface;
import com.agilysys.pms.common.client.export.WarehouseMaintenanceClient;

public class AccountWarehouseMaintenanceClient
      extends WarehouseMaintenanceClient<AccountWarehouseMaintenanceInterface> {
    public AccountWarehouseMaintenanceClient(String uri) {
        super(AccountWarehouseMaintenanceInterface.class, uri);
    }
}
