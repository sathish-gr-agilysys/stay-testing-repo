package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.LedgerSettingsInterface;
import com.agilysys.pms.common.client.StayServiceClient;

public class LedgerSettingsClient extends StayServiceClient<LedgerSettingsInterface> {
    public LedgerSettingsClient(String uri) {
        super(LedgerSettingsInterface.class, uri);
    }
}
