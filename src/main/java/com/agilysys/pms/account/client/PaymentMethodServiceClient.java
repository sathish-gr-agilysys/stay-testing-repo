/*
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.PaymentMethodInterface;
import com.agilysys.pms.common.auth.ApiKeyAuthHandler;
import com.agilysys.pms.common.client.StayServiceClient;

public class PaymentMethodServiceClient extends StayServiceClient<PaymentMethodInterface> {
    public PaymentMethodServiceClient(String uri) {
        super(PaymentMethodInterface.class, uri);
    }

    public PaymentMethodServiceClient(String uri, ApiKeyAuthHandler apiKeyAuthHandler) {
        super(PaymentMethodInterface.class, uri, apiKeyAuthHandler);
    }

    public PaymentMethodServiceClient(String uri, int limit) {
        super(PaymentMethodInterface.class, uri, limit);
    }

    public PaymentMethodServiceClient(String uri, ApiKeyAuthHandler apiKeyAuthHandler, int limit) {
        super(PaymentMethodInterface.class, uri, apiKeyAuthHandler, limit);
    }
}
