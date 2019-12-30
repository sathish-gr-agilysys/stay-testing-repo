/**
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.HtngCategoryConfigServiceInterface;
import com.agilysys.pms.common.client.StayServiceClient;

/**
 * Client proxy for {@link HtngCategoryConfigServiceInterface}
 */
public class HtngCategoryServiceClient extends StayServiceClient<HtngCategoryConfigServiceInterface> {
    public HtngCategoryServiceClient(String uri) {
        super(HtngCategoryConfigServiceInterface.class, uri);
    }
}
