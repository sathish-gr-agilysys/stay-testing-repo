/*
 * (C) 2019 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package com.agilysys.pms.account.client;

import javax.ws.rs.core.Response.Status;

import com.agilysys.platform.rest.provider.ClientProviderConfigurer;
import com.agilysys.pms.account.api.AccountServiceInterfaceV1;
import com.agilysys.pms.common.client.InheritedExceptionReader;
import com.agilysys.pms.common.client.StayServiceClient;
import com.agilysys.pms.common.exceptions.NextGenExceptionToggle;

public class AccountServiceV1Client extends StayServiceClient<AccountServiceInterfaceV1> {
    public AccountServiceV1Client(String uri) {
        super(AccountServiceInterfaceV1.class, uri, clientProviderConfigurer());
    }

    public AccountServiceV1Client(String uri, int limit) {
        super(AccountServiceInterfaceV1.class, uri, clientProviderConfigurer(), limit);
    }

    protected static ClientProviderConfigurer clientProviderConfigurer() {
        ClientProviderConfigurer configurer = StayServiceClient.clientProviderConfigurer();
        if (!NextGenExceptionToggle.isEnabled()) {
            configurer.getServiceExceptionReaderMap().put(Status.BAD_REQUEST.getStatusCode(),
                  new InheritedExceptionReader(new PayoffBalanceExceptionReader()));
        }
        return configurer;
    }
}
