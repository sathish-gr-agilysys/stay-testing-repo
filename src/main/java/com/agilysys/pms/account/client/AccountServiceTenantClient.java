/*
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.AccountServiceTenantInterface;
import com.agilysys.pms.common.auth.ApiKeyAuthHandler;
import com.agilysys.pms.common.client.StayServiceClient;

public class AccountServiceTenantClient extends StayServiceClient<AccountServiceTenantInterface> {
    public AccountServiceTenantClient(String uri) {
        super(AccountServiceTenantInterface.class, uri);
    }

    public AccountServiceTenantClient(String uri, ApiKeyAuthHandler apiKeyAuthHandler) {
        super(AccountServiceTenantInterface.class, uri, apiKeyAuthHandler);
    }
}
