/*
 * (C) 2014 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.RecurringChargesServiceInterface;
import com.agilysys.pms.common.auth.ApiKeyAuthHandler;
import com.agilysys.pms.common.client.StayServiceClient;

public class RecurringChargesServiceClient extends StayServiceClient<RecurringChargesServiceInterface> {
    public RecurringChargesServiceClient(String uri) {
        super(RecurringChargesServiceInterface.class, uri);
    }

    public RecurringChargesServiceClient(String uri, ApiKeyAuthHandler apiKeyAuthHandler) {
        super(RecurringChargesServiceInterface.class, uri, apiKeyAuthHandler);
    }
}
