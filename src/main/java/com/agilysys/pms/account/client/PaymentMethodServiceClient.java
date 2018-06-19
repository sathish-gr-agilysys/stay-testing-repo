/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.PaymentMethodInterface;
import com.agilysys.pms.common.client.StayServiceClient;

/**
 * Client proxy for {@link com.agilysys.pms.account.api.PaymentMethodInterface}
 */
public class PaymentMethodServiceClient extends StayServiceClient<PaymentMethodInterface> {
    public PaymentMethodServiceClient(String uri) {
        super(PaymentMethodInterface.class, uri);
    }
}
