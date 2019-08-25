/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.PantryServiceInterface;
import com.agilysys.pms.common.client.StayServiceClient;

/**
 * Client proxy for {@link com.agilysys.pms.account.api.PantryServiceInterface}
 */
public class PantryServiceClient extends StayServiceClient<PantryServiceInterface> {
    public PantryServiceClient(String uri) {
        super(PantryServiceInterface.class, uri);
    }
}
