/**
 * (C) 2013 Agilysys NV, LLC. All Rights Reserved. Confidential Information of Agilysys NV, LLC.
 */

package com.agilysys.pms.account.client;

import com.agilysys.platform.rest.provider.ClientProviderConfigurer;
import com.agilysys.pms.account.api.AccountServiceInterface;
import com.agilysys.pms.common.client.InheritedExceptionReader;
import com.agilysys.pms.common.client.StayServiceClient;
import com.agilysys.pms.payment.exception.PaymentServiceExceptionReader;
import com.agilysys.pms.rguestpayshim.exception.reader.PayExceptionReader;

/**
 * Client proxy for {@link AccountServiceInterface}
 */
public class AccountServiceClient extends StayServiceClient<AccountServiceInterface> {
    public AccountServiceClient(String uri) {
        super(AccountServiceInterface.class, uri, providerConfigurer());
    }

    private static ClientProviderConfigurer providerConfigurer() {
        ClientProviderConfigurer configurer = new ClientProviderConfigurer();
        configurer.getReaderMap()
              .put(null, new InheritedExceptionReader(new PayExceptionReader(), new PaymentServiceExceptionReader()));
        return configurer;
    }
}
