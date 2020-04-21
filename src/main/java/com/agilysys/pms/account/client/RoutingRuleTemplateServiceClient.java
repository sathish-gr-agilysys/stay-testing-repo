/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.RoutingRuleTemplateServiceInterface;
import com.agilysys.pms.common.client.StayServiceClient;

public class RoutingRuleTemplateServiceClient extends StayServiceClient<RoutingRuleTemplateServiceInterface> {
    public RoutingRuleTemplateServiceClient(String uri) {
        super(RoutingRuleTemplateServiceInterface.class, uri);
    }
}
