/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.HouseAccountCategoryInterface;
import com.agilysys.pms.common.auth.ApiKeyAuthHandler;
import com.agilysys.pms.common.client.StayServiceClient;

public class HouseAccountCategoryServiceClient extends StayServiceClient<HouseAccountCategoryInterface> {
    public HouseAccountCategoryServiceClient(String uri) {
        super(HouseAccountCategoryInterface.class, uri);
    }

    public HouseAccountCategoryServiceClient(String uri, ApiKeyAuthHandler apiKeyAuthHandler) {
        super(HouseAccountCategoryInterface.class, uri, apiKeyAuthHandler);
    }
}
