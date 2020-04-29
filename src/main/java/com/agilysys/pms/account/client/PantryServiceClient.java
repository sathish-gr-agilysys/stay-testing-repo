/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.PantryServiceInterface;
import com.agilysys.pms.common.auth.ApiKeyAuthHandler;
import com.agilysys.pms.common.client.StayServiceClient;

public class PantryServiceClient extends StayServiceClient<PantryServiceInterface> {
    public PantryServiceClient(String uri) {
        super(PantryServiceInterface.class, uri);
    }

    public PantryServiceClient(String uri, ApiKeyAuthHandler apiKeyAuthHandler) {
        super(PantryServiceInterface.class, uri, apiKeyAuthHandler);
    }
}
