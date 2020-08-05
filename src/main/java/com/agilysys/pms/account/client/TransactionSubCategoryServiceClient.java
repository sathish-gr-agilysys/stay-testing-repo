/*
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.TransactionSubCategoryConfigServiceInterface;
import com.agilysys.pms.common.auth.ApiKeyAuthHandler;
import com.agilysys.pms.common.client.StayServiceClient;

public class TransactionSubCategoryServiceClient
      extends StayServiceClient<TransactionSubCategoryConfigServiceInterface> {
    public TransactionSubCategoryServiceClient(String uri) {
        super(TransactionSubCategoryConfigServiceInterface.class, uri);
    }

    public TransactionSubCategoryServiceClient(String uri, ApiKeyAuthHandler apiKeyAuthHandler) {
        super(TransactionSubCategoryConfigServiceInterface.class, uri, apiKeyAuthHandler);
    }
}
