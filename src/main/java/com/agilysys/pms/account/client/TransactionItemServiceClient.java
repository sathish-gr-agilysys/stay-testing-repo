/*
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.TransactionItemConfigServiceInterface;
import com.agilysys.pms.common.auth.ApiKeyAuthHandler;
import com.agilysys.pms.common.client.StayServiceClient;

public class TransactionItemServiceClient extends StayServiceClient<TransactionItemConfigServiceInterface> {
    public TransactionItemServiceClient(String uri) {
        super(TransactionItemConfigServiceInterface.class, uri);
    }

    public TransactionItemServiceClient(String uri, ApiKeyAuthHandler apiKeyAuthHandler) {
        super(TransactionItemConfigServiceInterface.class, uri, apiKeyAuthHandler);
    }
}
