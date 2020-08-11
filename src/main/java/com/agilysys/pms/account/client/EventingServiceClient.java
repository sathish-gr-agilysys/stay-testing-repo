/*
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.EventingInterface;
import com.agilysys.pms.common.auth.ApiKeyAuthHandler;
import com.agilysys.pms.common.client.StayServiceClient;

public class EventingServiceClient extends StayServiceClient<EventingInterface> {
    public EventingServiceClient(String uri) {
        super(EventingInterface.class, uri);
    }

    public EventingServiceClient(String uri, ApiKeyAuthHandler apiKeyAuthHandler) {
        super(EventingInterface.class, uri, apiKeyAuthHandler);
    }
}
