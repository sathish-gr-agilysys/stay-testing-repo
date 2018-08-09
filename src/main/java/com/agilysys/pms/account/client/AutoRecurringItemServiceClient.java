/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.AutoRecurringItemConfigServiceInterface;
import com.agilysys.pms.common.client.StayServiceClient;

public class AutoRecurringItemServiceClient extends StayServiceClient<AutoRecurringItemConfigServiceInterface> {
    public AutoRecurringItemServiceClient(String uri) {
        super(AutoRecurringItemConfigServiceInterface.class, uri);
    }
}
