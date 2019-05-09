/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.MaintenanceInterface;
import com.agilysys.pms.common.client.StayServiceClient;

public class MaintenanceClient extends StayServiceClient<MaintenanceInterface> {
    public MaintenanceClient(String uri) {
        super(MaintenanceInterface.class, uri);
    }
}