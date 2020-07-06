/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.ThresholdAmountInterface;
import com.agilysys.pms.common.auth.ApiKeyAuthHandler;
import com.agilysys.pms.common.client.StayServiceClient;

public class ThresholdAmountServiceClient extends StayServiceClient<ThresholdAmountInterface> {

    public ThresholdAmountServiceClient(String uri) {
        super(ThresholdAmountInterface.class, uri);
    }

    public ThresholdAmountServiceClient(String uri, ApiKeyAuthHandler apiKeyAuthHandler) {
        super(ThresholdAmountInterface.class, uri, apiKeyAuthHandler);
    }
}
