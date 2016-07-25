/**
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.TransactionSubCategoryConfigServiceInterface;
import com.agilysys.pms.common.client.StayServiceClient;

/**
 * Client proxy for {@link TransactionSubCategoryConfigServiceInterface}
 */
public class TransactionSubCategoryServiceClient
      extends StayServiceClient<TransactionSubCategoryConfigServiceInterface> {
    public TransactionSubCategoryServiceClient(String uri) {
        super(TransactionSubCategoryConfigServiceInterface.class, uri);
    }
}
