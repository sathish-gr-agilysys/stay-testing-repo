/*
 * (C) 2015 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.CompReasonInterface;
import com.agilysys.pms.common.client.StayServiceClient;

public class CompReasonServiceClient extends StayServiceClient<CompReasonInterface> {
    public CompReasonServiceClient(String uri) {
        super(CompReasonInterface.class, uri);
    }
}
