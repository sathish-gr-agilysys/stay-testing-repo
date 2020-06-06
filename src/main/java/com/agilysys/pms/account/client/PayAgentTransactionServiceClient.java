/*
 * (C) 2015 Agilysys NV, LLC. All Rights Reserved. Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.PayAgentTransactionInterface;
import com.agilysys.pms.common.auth.ApiKeyAuthHandler;
import com.agilysys.pms.common.client.StayServiceClient;

public class PayAgentTransactionServiceClient extends StayServiceClient<PayAgentTransactionInterface> {
    public PayAgentTransactionServiceClient(String uri) {
        super(PayAgentTransactionInterface.class, uri);
    }

    public PayAgentTransactionServiceClient(String uri, ApiKeyAuthHandler apiKeyAuthHandler) {
        super(PayAgentTransactionInterface.class, uri, apiKeyAuthHandler);
    }
}
