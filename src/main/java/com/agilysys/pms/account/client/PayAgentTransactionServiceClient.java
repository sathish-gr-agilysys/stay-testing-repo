/**
 * (C) 2015 Agilysys NV, LLC. All Rights Reserved. Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.PayAgentTransactionInterface;
import com.agilysys.pms.common.client.StayServiceClient;

/**
 * Client proxy for {@link com.agilysys.pms.account.api.PayAgentTransactionInterface}
 */
public class PayAgentTransactionServiceClient extends StayServiceClient<PayAgentTransactionInterface> {
    public PayAgentTransactionServiceClient(String uri) {
        super(PayAgentTransactionInterface.class, uri);
    }
}
