/*
 * (C) 2020 Agilysys NV, LLC. All Rights Reserved. Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.TaxGroupsInterface;
import com.agilysys.pms.common.auth.ApiKeyAuthHandler;
import com.agilysys.pms.common.client.StayServiceClient;

public class TaxGroupsClient extends StayServiceClient<TaxGroupsInterface> {
    public TaxGroupsClient(String uri) {
        super(TaxGroupsInterface.class, uri);
    }

    public TaxGroupsClient(String uri, ApiKeyAuthHandler apiKeyAuthHandler) {
        super(TaxGroupsInterface.class, uri, apiKeyAuthHandler);
    }
}
