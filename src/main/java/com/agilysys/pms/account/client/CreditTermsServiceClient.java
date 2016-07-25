/*
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.CreditTermsInterface;
import com.agilysys.pms.common.client.StayServiceClient;

public class CreditTermsServiceClient extends StayServiceClient<CreditTermsInterface> {
    public CreditTermsServiceClient(String uri) {
        super(CreditTermsInterface.class, uri);
    }
}
