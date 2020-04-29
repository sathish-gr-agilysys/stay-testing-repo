/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.HtngCategoryConfigServiceInterface;
import com.agilysys.pms.common.auth.ApiKeyAuthHandler;
import com.agilysys.pms.common.client.StayServiceClient;

public class HtngCategoryServiceClient extends StayServiceClient<HtngCategoryConfigServiceInterface> {
    public HtngCategoryServiceClient(String uri) {
        super(HtngCategoryConfigServiceInterface.class, uri);
    }

    public HtngCategoryServiceClient(String uri, ApiKeyAuthHandler apiKeyAuthHandler) {
        super(HtngCategoryConfigServiceInterface.class, uri, apiKeyAuthHandler);
    }
}
