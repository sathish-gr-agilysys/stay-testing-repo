/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.LedgerSettingsInterface;
import com.agilysys.pms.common.auth.ApiKeyAuthHandler;
import com.agilysys.pms.common.client.StayServiceClient;

public class LedgerSettingsClient extends StayServiceClient<LedgerSettingsInterface> {
    public LedgerSettingsClient(String uri) {
        super(LedgerSettingsInterface.class, uri);
    }

    public LedgerSettingsClient(String uri, ApiKeyAuthHandler apiKeyAuthHandler) {
        super(LedgerSettingsInterface.class, uri, apiKeyAuthHandler);
    }
}
