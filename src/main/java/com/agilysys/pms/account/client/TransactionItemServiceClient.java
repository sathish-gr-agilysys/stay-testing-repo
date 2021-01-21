/*
 * (C) 2013 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.TransactionItemConfigServiceInterface;
import com.agilysys.pms.common.auth.ApiKeyAuthHandler;
import com.agilysys.pms.common.client.caching.CachingClient;
import com.agilysys.pms.common.client.caching.CachingClientContext;

public class TransactionItemServiceClient extends CachingClient<TransactionItemConfigServiceInterface> {
    public TransactionItemServiceClient(String uri) {
        super(TransactionItemConfigServiceInterface.class, uri, null);
    }

    public TransactionItemServiceClient(String uri, ApiKeyAuthHandler apiKeyAuthHandler) {
        super(TransactionItemConfigServiceInterface.class, uri, apiKeyAuthHandler, null);
    }

    public TransactionItemServiceClient(String uri, ApiKeyAuthHandler apiKeyAuthHandler, CachingClientContext context) {
        super(TransactionItemConfigServiceInterface.class, uri, apiKeyAuthHandler, context);
    }
}