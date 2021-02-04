/*
 * (C) 2020 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import org.springframework.beans.factory.annotation.Value;

import com.agilysys.pms.account.api.RoutingRuleTemplateServiceInterface;
import com.agilysys.pms.common.auth.ApiKeyAuthHandler;
import com.agilysys.pms.common.client.StayServiceClient;

public class RoutingRuleTemplateServiceClient extends StayServiceClient<RoutingRuleTemplateServiceInterface> {
    public RoutingRuleTemplateServiceClient(String uri) {
        super(RoutingRuleTemplateServiceInterface.class, uri);
    }

    public RoutingRuleTemplateServiceClient(@Value("${account.uri}") String uri, ApiKeyAuthHandler apiKeyAuthHandler) {
        super(RoutingRuleTemplateServiceInterface.class, uri, apiKeyAuthHandler);
    }
}
