/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.InventoryItemConfigServiceInterface;
import com.agilysys.pms.common.client.StayServiceClient;

public class InventoryItemServiceClient extends StayServiceClient<InventoryItemConfigServiceInterface> {
    public InventoryItemServiceClient(String uri) {
        super(InventoryItemConfigServiceInterface.class, uri);
    }
}

