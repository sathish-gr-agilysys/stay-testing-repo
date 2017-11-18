/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.NonRoomInventoryItemConfigServiceInterface;
import com.agilysys.pms.common.client.StayServiceClient;

public class NonRoomInventoryItemServiceClient extends StayServiceClient<NonRoomInventoryItemConfigServiceInterface> {
    public NonRoomInventoryItemServiceClient(String uri) {
        super(NonRoomInventoryItemConfigServiceInterface.class, uri);
    }
}

