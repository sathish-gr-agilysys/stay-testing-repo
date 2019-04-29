/**
 * (C) 2018 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import com.agilysys.pms.account.api.AccountServiceTenantInterface;
import com.agilysys.pms.common.client.StayServiceClient;

/**
 * Client proxy for {@link com.agilysys.pms.account.api.AccountServiceTenantInterface}
 */
public class AccountServiceTenantClient extends StayServiceClient<AccountServiceTenantInterface> {
    public AccountServiceTenantClient(String uri) {
        super(AccountServiceTenantInterface.class, uri);
    }
}