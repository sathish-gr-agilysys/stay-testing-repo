/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.AutoRecurringItemConfigServiceInterface;
import com.agilysys.pms.account.api.RoutingRuleTemplateConfigServiceInterface;
import com.agilysys.pms.common.client.StayServiceClient;

public class RoutingRuleTemplateServiceClient extends StayServiceClient<RoutingRuleTemplateConfigServiceInterface> {
    public RoutingRuleTemplateServiceClient(String uri) {
        super(RoutingRuleTemplateConfigServiceInterface.class, uri);
    }
}
