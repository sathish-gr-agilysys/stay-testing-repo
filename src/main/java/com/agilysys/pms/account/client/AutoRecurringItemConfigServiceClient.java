/*
 * (C) 2022 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.AutoRecurringItemConfigServiceInterface;
import com.agilysys.pms.common.auth.ApiKeyAuthHandler;
import com.agilysys.pms.common.client.StayServiceClient;

public class AutoRecurringItemConfigServiceClient extends StayServiceClient<AutoRecurringItemConfigServiceInterface> {
    public AutoRecurringItemConfigServiceClient(String uri) {
        super(AutoRecurringItemConfigServiceInterface.class, uri);
    }

    public AutoRecurringItemConfigServiceClient(String uri, ApiKeyAuthHandler apiKeyAuthHandler) {
        super(AutoRecurringItemConfigServiceInterface.class, uri, apiKeyAuthHandler);
    }
}