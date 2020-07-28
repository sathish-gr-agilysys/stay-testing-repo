/*
 * (C) 2014 Agilysys NV, LLC. All Rights Reserved. Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.ReportingServiceInterface;
import com.agilysys.pms.common.auth.ApiKeyAuthHandler;
import com.agilysys.pms.common.client.StayServiceClient;

public class ReportingServiceClient extends StayServiceClient<ReportingServiceInterface> {
    public ReportingServiceClient(String uri) {
        super(ReportingServiceInterface.class, uri);
    }

    public ReportingServiceClient(String uri, ApiKeyAuthHandler apiKeyAuthHandler) {
        super(ReportingServiceInterface.class, uri, apiKeyAuthHandler);
    }
}
