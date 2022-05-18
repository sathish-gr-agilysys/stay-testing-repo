/*
 * (C) 2022 Agilysys NV, LLC. All Rights Reserved. Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.TaxGroupsInterface;
import com.agilysys.pms.account.api.TaxSummaryConfigInterface;
import com.agilysys.pms.common.auth.ApiKeyAuthHandler;
import com.agilysys.pms.common.client.StayServiceClient;

public class TaxSummaryConfigClient extends StayServiceClient<TaxSummaryConfigInterface> {
    public TaxSummaryConfigClient(String uri) {
        super(TaxSummaryConfigInterface.class, uri);
    }

    public TaxSummaryConfigClient(String uri, ApiKeyAuthHandler apiKeyAuthHandler) {
        super(TaxSummaryConfigInterface.class, uri, apiKeyAuthHandler);
    }
}
